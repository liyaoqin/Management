package com.science.admin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.science.admin.mapper.ProjectMapper;
import com.science.admin.mapper.ResultMapper;
import com.science.admin.model.Rresult;
import com.science.admin.pojo.Project;
import com.science.admin.pojo.Result;
import com.science.admin.pojo.ResultExample;
import com.science.admin.service.ResultService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;
    
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ScienceResult createResult(Result cresult,long pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        project.setIfconcluding((byte)1);
        projectMapper.updateByPrimaryKey(project);
        //插入到数据库
        cresult.setSchange((byte)0);
        cresult.setAudit("未审核");
        cresult.setCreated(new Date());
        cresult.setUpdated(new Date());
        resultMapper.insert(cresult);
        return ScienceResult.ok();
    }

    @Override
    public LUDataGridResult getResultList(int page, int limit) {
        ResultExample example=new ResultExample();
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getNresultList(int page, int limit, long userid) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid).andAuditEqualTo("未审核");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getSresultList(int page, int limit, long userid) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid).andAuditEqualTo("审核通过");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getFresultList(int page, int limit, long userid) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        List fieldValues = new ArrayList();
        fieldValues.add("未审核");
        fieldValues.add("审核通过");
        criteria.andUserIdEqualTo(userid).andAuditNotIn(fieldValues);
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setReason(rresult.getAudit());
            rresult.setAudit("<button class=\"layui-btn layui-btn-xs\" pid=\""+rresult.getId()+"\">重新申报</button>");
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminNresultList(int page, int limit) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        criteria.andAuditEqualTo("未审核");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setApprove("<button id=\"pass\" class=\"layui-btn layui-btn-xs\" " +
                    "pid=\""+rresult.getId()+"\">通过</button><button id=\"npass\" class=\"layui-btn layui-btn-xs\" " +
                    "pid=\""+rresult.getId()+"\">不通过</button>");
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminSresultList(int page, int limit) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        criteria.andAuditEqualTo("审核通过");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminFresultList(int page, int limit) {
        ResultExample example=new ResultExample();
        ResultExample.Criteria criteria = example.createCriteria();
        List fieldValues = new ArrayList();
        fieldValues.add("未审核");
        fieldValues.add("审核通过");
        criteria.andAuditNotIn(fieldValues);
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Result> list = resultMapper.selectByExample(example);
        List<Rresult> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Result result:list){
            Rresult rresult=new Rresult();
            BeanUtils.copyProperties(result,rresult);
            rresult.setCresults("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rresult.getCresults()+"\">下载此结题材料</a></button>");
            rresult.setReason(result.getAudit());
            rresult.setDate(sdf.format(rresult.getCreated()));
            rlist.add(rresult);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Result> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public Result getResult(long id) {
        Result result = resultMapper.selectByPrimaryKey(id);
        return result;
    }

    @Override
    public ScienceResult delResult(long id) {
        int i = resultMapper.deleteByPrimaryKey(id);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult editResult(Result result) {
        Result eresult = resultMapper.selectByPrimaryKey(result.getId());
        eresult.setCresults(result.getCresults());
        int i = resultMapper.updateByPrimaryKey(eresult);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult againResult(Result result) {
        Result eresult=resultMapper.selectByPrimaryKey(result.getId());
        eresult.setCresults(result.getCresults());
        eresult.setAudit("未审核");
        resultMapper.updateByPrimaryKey(eresult);
        return ScienceResult.ok();

    }

    @Override
    public ScienceResult passResult(long id) {
        Result result = resultMapper.selectByPrimaryKey(id);
        result.setAudit("审核通过");
        int i = resultMapper.updateByPrimaryKey(result);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult npassResult(Result result) {
        Result nresult = resultMapper.selectByPrimaryKey(result.getId());
        nresult.setAudit(result.getAudit());
        int i = resultMapper.updateByPrimaryKey(nresult);
        return ScienceResult.ok();
    }

}
