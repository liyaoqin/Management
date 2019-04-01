package com.science.admin.controller;

import com.science.admin.entity.ProgressEntity;
import com.science.admin.properties.FileUploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private FileUploadProperties fileUploadProperties;
    @RequestMapping("/pic")
    public Map<String, Object> upload(MultipartFile file){
        Map<String, Object> result = new HashMap<>();
        String originalFilename=file.getOriginalFilename();
        if (file != null){
            String path=fileUploadProperties.getUploadFolder()+"\\";
            File pfile=new File(path);
            if(!pfile.exists()){
                pfile.mkdirs();
            }
           String nextpath=System.currentTimeMillis()+"/";
            File nfile=new File(path+nextpath);
            if(!nfile.exists()){
                nfile.mkdirs();
            }
           String newFileName=nextpath+originalFilename;
            try {
                file.transferTo(new File(path+newFileName));
                result.put("code", 0);
                result.put("msg", "success");
                result.put("href",newFileName);
            } catch (IOException e) {
                result.put("code", 1);
                result.put("msg", "文件上传出错，请重新上传！");
                e.printStackTrace();
            }
        } else {
            result.put("code",2);
            result.put("msg", "未获取到有效的文件信息，请重新上传!");
        }
        return result;
    }
    /**
     * 获取文件上传进度
     * @param request
     * @return
     */
    @RequestMapping("getUploadProgress")
    @ResponseBody
    public ProgressEntity getUploadProgress(HttpServletRequest request){
        return (ProgressEntity) request.getSession().getAttribute("uploadStatus");
    }

    @RequestMapping("/download")
    public void downloadFile(String filename, HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse) throws IOException {
        /*******************2.对接收的参数进行编码处理**************************/
        //获取参数  ，默认会对参数进行编码    ISO8859-1
        //把乱码转回二进制位
        //byte[] bytes = filename.getBytes("ISO8859-1");
        //再去使用UTF-8进行编码
        //filename = new String(bytes,"UTF-8");

        /*******************3.告诉浏览器响应的文件的类型*************************/
        // 根据文件名来获取mime类型
        String mimeType = httpServletRequest.getSession().getServletContext().getMimeType(filename);
        // 设置 mimeType
        httpServletResponse.setContentType(mimeType);

        /*******************4.告诉浏览器以附件的形式下载*************************/
        // 获取客户端信息
        String agent = httpServletRequest.getHeader("User-Agent");
        // 定义一个变量记录编码之后的名字
        String filenameEncoder = "";
        if (agent.contains("MSIE")) {
            // IE编码
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐编码
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 浏览器编码
            filenameEncoder = URLEncoder.encode(filename, "utf-8");
        }

        // 告诉浏览器是以附件形式来下载 不要解析
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);

        /********************5.加载文件响应给浏览器*************************/
        // 拼接文件的路径

        String path = fileUploadProperties.getUploadFolder()+"\\"+filename;
        // 根据path加载文件
        FileInputStream in = new FileInputStream(path);
        // 获取响应的输出
        ServletOutputStream out = httpServletResponse.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            // 写到响应当中
            out.write(buffer, 0, len);
        }
        // 关闭文件
        in.close();
        out.close();
    }

}
