package com.science.admin.util;


import com.science.admin.model.Excel;
import com.science.admin.model.ReturnResult;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtil<T>
{

    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public Class<T> clazz;

    public ExcelUtil(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    /**
     * 用于将科学计数法式的数字转换为常规数字显示,BigDecimal表示。<br>
     * 如：6.913084212242E12  转换成：6940282300075
     * @param obj as Object
     * @return
     */
    public static String decimal2string(Object obj){
        BigDecimal big = null;
        if(obj==null) {
            return "";
        }

        if(obj instanceof Number){
            big = new BigDecimal(((Number)obj).doubleValue());
        }else{
            return obj.toString();
        }
        return big==null ? "" : big.toPlainString();
    }
    public List<T> importExcel(String sheetName, InputStream input) throws Exception
    {
        List<T> list = new ArrayList<T>();

        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = null;
        if(StringUtils.isEmpty(sheetName)){
            sheet = workbook.getSheetAt(0);
        }else{
            sheet = workbook.getSheet(sheetName);
        }
        int rows = sheet.getPhysicalNumberOfRows();

        if (rows > 0)
        {
            // 有数据时才处理 得到类的所有field.
            Field[] allFields = clazz.getDeclaredFields();
            // 定义一个map用于存放列的序号和field.
            List< Field> fieldsMap = new ArrayList<>();
            for (int col = 0; col < allFields.length; col++)
            {
                Field field = allFields[col];
                // 将有注解的field存放到map中.
                if (field.isAnnotationPresent(Excel.class))
                {
                    // 设置类的私有字段属性可访问.
                    field.setAccessible(true);
                    fieldsMap.add(field);
                }
            }
            for (int i = 1; i < rows; i++)
            {
                // 从第2行开始取数据,默认第一行是表头.
                Row row = sheet.getRow(i);
                //获取一行所有的单元格的数量
                int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
                T entity = null;
                for (int j = 0; j < cellNum; j++)
                {
                    Cell cell = row.getCell(j);
                    if (cell == null)
                    {
                        continue;
                    }
                    else
                    {
                        cell = row.getCell(j);
                    }

                    String c = null;
                    if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
                    {
                        c = decimal2string(cell.getNumericCellValue());
                    }else{
                        c = cell.getStringCellValue();
                    }
                    if (StringUtils.isEmpty(c))
                    {
                        continue;
                    }
                    c= replaceBlank(c);
                    // 如果不存在实例则新建.
                    entity = entity == null ? clazz.newInstance() : entity;
                    // 从map中得到对应列的field.
                    Field field = fieldsMap.get(j);
                    // 取得类型,并根据对象类型设置值.
                    Class<?> fieldType = field.getType();
//                    Class<?> fieldType = String.class;
                    if (String.class == fieldType)
                    {
                        field.set(entity, String.valueOf(c));
                    }
                    else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType))
                    {
                        field.set(entity, Integer.parseInt(c));
                    }
                    else if ((Long.TYPE == fieldType) || (Long.class == fieldType))
                    {
                        field.set(entity, Long.valueOf(c));
                    }
                    else if ((Float.TYPE == fieldType) || (Float.class == fieldType))
                    {
                        field.set(entity, Float.valueOf(c));
                    }
                    else if ((Short.TYPE == fieldType) || (Short.class == fieldType))
                    {
                        field.set(entity, Short.valueOf(c));
                    }
                    else if ((Double.TYPE == fieldType) || (Double.class == fieldType))
                    {
                        field.set(entity, Double.valueOf(c));
                    }
                    else if (Character.TYPE == fieldType)
                    {
                        if ((c != null) && (c.length() > 0))
                        {
                            field.set(entity, Character.valueOf(c.charAt(0)));
                        }
                    }
                    else if (Date.class == fieldType)
                    {
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            cell.setCellValue(sdf.format(cell.getNumericCellValue()));
                            c = sdf.format(cell.getNumericCellValue());
                        }
                        else
                        {
                            c = cell.getStringCellValue();
                        }
                    }
                    else if (BigDecimal.class == fieldType)
                    {
                        c = cell.getStringCellValue();
                    }
                }
                if (entity != null)
                {
                    list.add(entity);
                }
            }
        }

        return list;
    }

    /**
     * 导出excel到网络（直接将http）
     *
     * @param list
     * @param sheetName
     * @param response
     * @return
     */
    public void exportExcelToWeb(List<T> list, String sheetName, HttpServletResponse response) {
        // 告诉浏览器用什么软件可以打开此文件
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(sheetName + ".xls", "utf-8"));
            this.exportExcel(list,sheetName,response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void download(List<T> list, String sheetName, HttpServletResponse response) throws UnsupportedEncodingException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fileName =df.format(new Date())+"导出数据";
        fileName = URLEncoder.encode(fileName, "UTF-8");
        try {
            response.addHeader("Content-Disposition", "attachment;filename=" +fileName + ".xls");
            this.exportExcel(list,sheetName,response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel到指定路径
     *
     * @param list
     * @param sheetName
     * @param path
     * @return
     */
    public ReturnResult exportExcelToPath(List<T> list, String sheetName, String path) {
        ReturnResult returnResult = null;
        try {
            OutputStream out = new FileOutputStream(path);
            returnResult = this.exportExcel(list,sheetName,out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnResult;
    }

    /**
     * 对list数据源将其里面的数据导入到excel表单
     *
     * 通过制定out，实现导出到磁盘/网络
     *
     * @param sheetName 工作表的名称
     */
    public ReturnResult exportExcel(List<T> list, String sheetName,OutputStream out) {
        // 得到所有定义字段
        Field[] allFields = clazz.getDeclaredFields();
        List<Field> fields = new ArrayList<Field>();
        // 得到所有field并存放到一个list中.
        for (Field field : allFields) {
            if (field.isAnnotationPresent(Excel.class)) {
                fields.add(field);
            }
        }

        // 产生工作薄对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        // excel2003中每个sheet中最多有65536行
        int sheetSize = 65536;
        // 取出一共有多少个sheet.
        double sheetNo = Math.ceil(list.size() / sheetSize);
        for (int index = 0; index <= sheetNo; index++) {
            // 产生工作表对象
            HSSFSheet sheet = workbook.createSheet();
            if (sheetNo == 0) {
                workbook.setSheetName(index, sheetName);
            } else {
                // 设置工作表的名称.
                workbook.setSheetName(index, sheetName + index);
            }
            HSSFRow row;
            HSSFCell cell; // 产生单元格

            // 产生一行
            row = sheet.createRow(0);
            // 写入各个字段的列头名称
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                Excel attr = field.getAnnotation(Excel.class);
                // 创建列
                cell = row.createCell(i);
                // 设置列中写入内容为String类型
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                HSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                if (attr.name().indexOf("注：") >= 0) {
                    HSSFFont font = workbook.createFont();
                    font.setColor(HSSFFont.COLOR_RED);
                    cellStyle.setFont(font);
                    cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
                    sheet.setColumnWidth(i, 6000);
                } else {
                    HSSFFont font = workbook.createFont();
                    // 粗体显示
                    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                    // 选择需要用到的字体格式
                    cellStyle.setFont(font);
                    cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

                    // 设置列宽
                    sheet.setColumnWidth(i, 3766);
                }
                cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                cellStyle.setWrapText(true);
                cell.setCellStyle(cellStyle);

                // 写入列名
                cell.setCellValue(attr.name());

                // 如果设置了提示信息则鼠标放上去提示.
                if (!StringUtils.isEmpty(attr.prompt())) {
                    // 这里默认设了2-101列提示.
                    setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, i, i);
                }
                // 如果设置了combo属性则本列只能选择不能输入
                if (attr.combo().length > 0) {
                    // 这里默认设了2-101列只能选择不能输入.
                    setHSSFValidation(sheet, attr.combo(), 1, 100, i, i);
                }
            }

            int startNo = index * sheetSize;
            int endNo = Math.min(startNo + sheetSize, list.size());
            // 写入各条记录,每条记录对应excel表中的一行
            HSSFCellStyle cs = workbook.createCellStyle();
            cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            for (int i = startNo; i < endNo; i++) {
                row = sheet.createRow(i + 1 - startNo);
                // 得到导出对象.
                T vo = (T) list.get(i);
                for (int j = 0; j < fields.size(); j++) {
                    // 获得field.
                    Field field = fields.get(j);
                    // 设置实体类私有属性可访问
                    field.setAccessible(true);
                    Excel attr = field.getAnnotation(Excel.class);
                    try {
                        // 根据Excel中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
                        if (attr.isExport()) {
                            // 创建cell
                            cell = row.createCell(j);
                            cell.setCellStyle(cs);
                            try {
                                if (String.valueOf(field.get(vo)).length() > 10) {
                                    throw new Exception("长度超过10位就不用转数字了");
                                }
                                // 如果可以转成数字则导出为数字类型
                                BigDecimal bc = new BigDecimal(String.valueOf(field.get(vo)));
                                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                                cell.setCellValue(bc.doubleValue());
                            } catch (Exception e) {
                                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                if (vo == null) {
                                    // 如果数据存在就填入,不存在填入空格.
                                    cell.setCellValue("");
                                } else {
                                    // 如果数据存在就填入,不存在填入空格.
                                    cell.setCellValue(field.get(vo) == null ? "" : String.valueOf(field.get(vo)));
                                }

                            }
                        }
                    }
                    catch (Exception e) {
                        log.error("导出Excel失败{}", e.getMessage());
                    }
                }
            }
        }
        try {
            String filename = encodingFilename(sheetName);
            //OutputStream out = new FileOutputStream(getfile() + filename);
            workbook.write(out);
            out.close();
            ReturnResult returnResult = new ReturnResult();
            returnResult.setMsg("filename");
            returnResult.setCode(1);
            return returnResult;
        }
        catch (Exception e) {
            log.error("关闭flush失败{}", e.getMessage());
            ReturnResult returnResult = new ReturnResult();
            returnResult.setMsg("导出Excel失败，请联系网站管理员！");
            returnResult.setCode(-1);
            return returnResult;
        }
    }

    /**
     * 设置单元格上提示
     *
     * @param sheet 要设置的sheet.
     * @param promptTitle 标题
     * @param promptContent 内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol 开始列
     * @param endCol 结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle, String promptContent, int firstRow,
                                          int endRow, int firstCol, int endCol)
    {
        // 构造constraint对象
        DVConstraint constraint = DVConstraint.createCustomFormulaConstraint("DD1");
        // 四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation dataValidationView = new HSSFDataValidation(regions, constraint);
        dataValidationView.createPromptBox(promptTitle, promptContent);
        sheet.addValidationData(dataValidationView);
        return sheet;
    }

    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     *
     * @param sheet 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol 开始列
     * @param endCol 结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow, int endRow,
                                              int firstCol, int endCol)
    {
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation dataValidationList = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(dataValidationList);
        return sheet;
    }

    /**
     * 编码文件名
     */
    public String encodingFilename(String filename)
    {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xls";
        return filename;
    }


    public  String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}