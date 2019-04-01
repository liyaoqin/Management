package com.science.admin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.science.admin.mapper.CdprojectMapper;
import com.science.admin.mapper.DnoticeMapper;
import com.science.admin.mapper.ProjectMapper;
import com.science.admin.model.Rdnotice;
import com.science.admin.pojo.Dnotice;
import com.science.admin.pojo.DnoticeExample;
import com.science.admin.pojo.Project;
import com.science.admin.pojo.ProjectExample;
import com.science.admin.service.DnoticeService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.IDUtils;
import com.science.common.util.ScienceResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DnoticeServiceImpl implements DnoticeService {

    @Autowired
    private DnoticeMapper dnoticeMapper;

    @Autowired
    private CdprojectMapper cdprojectMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ScienceResult createDnotice(Dnotice dnotice) {
        //生成通知ID
        long id = IDUtils.genItemId();
        dnotice.setId(id);
        //'通知状态',0-未结题,1-结题
        dnotice.setStatus((byte) 0);
        dnotice.setCreated(new Date());
        dnotice.setUpdated(new Date());
        //插入到数据库
        dnoticeMapper.insert(dnotice);
        return ScienceResult.ok();
    }

    @Override
    public LUDataGridResult getDnoticeList(int page, int limit) {

        DnoticeExample example = new DnoticeExample();
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Dnotice> list = dnoticeMapper.selectByExampleWithBLOBs(example);
        List<Rdnotice> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Dnotice dnotice:list){
            Rdnotice rdnotice=new Rdnotice();
            BeanUtils.copyProperties(dnotice,rdnotice);
            rdnotice.setDeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rdnotice.getDeclaration()+"\">下载该通知项目申报书模板</a" +
                    "></button>");
            if(rdnotice.getStatus()==0){
                rdnotice.setConcluding("<button class=\"layui-btn layui-btn-xs\" pid=\""+rdnotice
                        .getId()+"\">发布结题通知</button>");
            }else{
                rdnotice.setConcluding("<button class=\"layui-btn layui-btn-primary layui-btn-xs layui-disabled\" " +
                        "pid=\""+rdnotice.getId()+"\">已发布结题通知</button>");
            }
            rdnotice.setDate(sdf.format(rdnotice.getCreated()));
            rlist.add(rdnotice);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Dnotice> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;

    }

    @Override
    public LUDataGridResult getNDnoticeList(int page, int limit) {
        DnoticeExample example = new DnoticeExample();
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Dnotice> list = dnoticeMapper.selectByExampleWithBLOBs(example);
        List<Rdnotice> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Dnotice dnotice:list){
            Rdnotice rdnotice=new Rdnotice();
            BeanUtils.copyProperties(dnotice,rdnotice);
            rdnotice.setDeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rdnotice.getDeclaration()+"\">下载该通知项目申报书模板</a" +
                    "></button>");
            rdnotice.setNumber("<button class=\"layui-btn layui-btn-xs\" pid=\""+rdnotice.getId()+"\">点击查看详情</button>");
            rdnotice.setDate(sdf.format(rdnotice.getCreated()));
            rlist.add(rdnotice);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Dnotice> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public Dnotice getDnotice(long id) {
        Dnotice dnotice = dnoticeMapper.selectByPrimaryKey(id);
        return dnotice;
    }

    @Override
    public ScienceResult delDnotice(long id) {
        int i = dnoticeMapper.deleteByPrimaryKey(id);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult editDnotice(Dnotice dnotice) {
        Dnotice ednotice = dnoticeMapper.selectByPrimaryKey(dnotice.getId());
        ednotice.setTitle(dnotice.getTitle());
        ednotice.setContent(dnotice.getContent());
        ednotice.setDeclaration(dnotice.getDeclaration());
        dnoticeMapper.updateByPrimaryKeyWithBLOBs(ednotice);
        return ScienceResult.ok();
    }

    @Override
    public LUDataGridResult getCdnoticeList(int page, int limit) {
        DnoticeExample example = new DnoticeExample();
        DnoticeExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte)0);
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Dnotice> list = dnoticeMapper.selectByExampleWithBLOBs(example);
        List<Rdnotice> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        for(Dnotice dnotice:list){
            Rdnotice rdnotice=new Rdnotice();
            BeanUtils.copyProperties(dnotice,rdnotice);
            rdnotice.setConcluding("<button class=\"layui-btn layui-btn-xs\" pid=\""+rdnotice
                        .getId()+"\">发布结题通知</button>");
            rdnotice.setDate(sdf.format(rdnotice.getCreated()));
            rlist.add(rdnotice);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Dnotice> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getCdprojectList(int page, int limit) {
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Dnotice> list =cdprojectMapper.getCdprojectList();
        List<Rdnotice> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Dnotice dnotice:list){
            Rdnotice rdnotice=new Rdnotice();
            BeanUtils.copyProperties(dnotice,rdnotice);
            rdnotice.setDeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rdnotice.getDeclaration()+"\">下载该通知申报书模板</a></button>");
            rdnotice.setConcluding("<button class=\"layui-btn layui-btn-xs\" pid=\""+rdnotice
                    .getId()+"\">申报项目</button>");
            rdnotice.setDate(sdf.format(rdnotice.getCreated()));
            rlist.add(rdnotice);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Dnotice> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

}
