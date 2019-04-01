package com.science.admin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.science.admin.mapper.ProjectMapper;
import com.science.admin.model.Rproject;
import com.science.admin.pojo.Project;
import com.science.admin.pojo.ProjectExample;
import com.science.admin.service.ProjectService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ScienceResult createProject(Project project, long pid) {
        //生成通知ID
        project.setDnoticeId(pid);
        project.setSnumber(UUID.randomUUID().toString());
        switch (project.getScategory()){
            case "0":
                project.setScategory("哲学社会科学类社会调查报告及学术论文");
                break;
            case "1":
                project.setScategory("自然科学类学术论文");
                break;
            case "2":
                project.setScategory("发明制作类作品");
                break;
            case "3":
                project.setScategory("创作成果类作品");
                break;
                default:
                    project.setScategory("");
        }
        switch (project.getDcategory()){
            case "0":
                project.setDcategory("机械与控制");
                break;
            case "1":
                project.setDcategory("信息技术");
                break;
            case "2":
                project.setDcategory("能源化工");
                break;
            case "3":
                project.setDcategory("生命科学");
                break;
            case "4":
                project.setDcategory("数理");
                break;
            default:
                project.setScategory("");
        }
        project.setIfconcluding((byte) 0);
        project.setAudit("未审核");
        project.setSchange((byte)0);
        project.setCreated(new Date());
        project.setUpdated(new Date());
        //插入到数据库
       projectMapper.insert(project);
        return ScienceResult.ok();
    }

    @Override
    public LUDataGridResult getProjectList(int page, int limit) {
        ProjectExample example=new ProjectExample();
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            if(rproject.getIfconcluding()==0){
                rproject.setConcludingstatus("<button class=\"layui-btn layui-btn-xs\" pid=\""+rproject
                        .getDnoticeId()+"\">申请结题</button>");
            }else{
                rproject.setConcludingstatus("<button class=\"layui-btn layui-btn-primary layui-btn-xs " +
                        "layui-disabled\" pid=\""+rproject
                        .getDnoticeId()+"\">已申请结题</button>");
            }
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getdetailProjectList(long id) {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andDnoticeIdEqualTo(id);
        List<Project> projects = projectMapper.selectByExample(example);
        LUDataGridResult result = new LUDataGridResult();
        result.setData(projects);
        result.setCount(projects.size());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getNprojectList(int page, int limit,long userid) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid).andAuditEqualTo("未审核");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminNprojectList(int page, int limit) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andAuditEqualTo("未审核");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            rproject.setApprove("<button id=\"pass\" class=\"layui-btn layui-btn-xs\" " +
                    "pid=\""+rproject.getId()+"\">通过</button><button id=\"npass\" class=\"layui-btn layui-btn-xs\" " +
                    "pid=\""+rproject.getId()+"\">不通过</button>");
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminSprojectList(int page, int limit) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andAuditEqualTo("审核通过");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getadminFprojectList(int page, int limit) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        List fieldValues = new ArrayList();
        fieldValues.add("未审核");
        fieldValues.add("审核通过");
        criteria.andAuditNotIn(fieldValues);
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            rproject.setReason(rproject.getAudit());
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }


    @Override
    public LUDataGridResult getSprojectList(int page, int limit, long userid) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid).andAuditEqualTo("审核通过");
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            if(rproject.getIfconcluding()==0){
                rproject.setConcludingstatus("<button class=\"layui-btn layui-btn-xs\" pid=\""+rproject
                        .getId()+"\">申报结题成果</button>");
            }else if(rproject.getIfconcluding()==1){
                rproject.setConcludingstatus("<button class=\"layui-btn layui-btn-primary layui-btn-xs " +
                        "layui-disabled\" pid=\""+rproject
                        .getDnoticeId()+"\">结题成果待审核</button>");
            }else{
                rproject.setConcludingstatus("<button class=\"layui-btn layui-btn-primary layui-btn-xs " +
                        "layui-disabled\" pid=\""+rproject
                        .getDnoticeId()+"\">该项目已成功结题</button>");
            }
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public LUDataGridResult getFprojectList(int page, int limit, long userid) {
        ProjectExample example=new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        List fieldValues = new ArrayList();
        fieldValues.add("未审核");
        fieldValues.add("审核通过");
        criteria.andUserIdEqualTo(userid).andAuditNotIn(fieldValues);
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Project> list = projectMapper.selectByExample(example);
        List<Rproject> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Project project:list){
            Rproject rproject=new Rproject();
            BeanUtils.copyProperties(project,rproject);
            rproject.setReason(rproject.getAudit());
            rproject.setPdeclaration("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rproject.getPdeclaration()+"\">下载此申报书</a></button>");
            rproject.setAudit("<button class=\"layui-btn layui-btn-xs\" pid=\""+rproject.getId()+"\">重新申报</button>");
            rproject.setDate(sdf.format(rproject.getCreated()));
            rlist.add(rproject);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Project> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public Project getProject(long id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        return project;
    }

    @Override
    public ScienceResult delProject(long id) {
        int i = projectMapper.deleteByPrimaryKey(id);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult passProject(long id) {
        Project project = projectMapper.selectByPrimaryKey(id);
        project.setAudit("审核通过");
        int i = projectMapper.updateByPrimaryKey(project);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult npassProject(Project project) {
        Project nproject = projectMapper.selectByPrimaryKey(project.getId());
        nproject.setAudit(project.getAudit());
        int i = projectMapper.updateByPrimaryKey(nproject);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult editProject(Project project) {
        Project eproject = projectMapper.selectByPrimaryKey(project.getId());
        switch (project.getScategory()){
            case "0":
                eproject.setScategory("哲学社会科学类社会调查报告及学术论文");
                break;
            case "1":
                eproject.setScategory("自然科学类学术论文");
                break;
            case "2":
                eproject.setScategory("发明制作类作品");
                break;
            case "3":
                project.setScategory("创作成果类作品");
                break;
            default:
                eproject.setScategory("");
        }
        switch (project.getDcategory()){
            case "0":
                eproject.setDcategory("机械与控制");
                break;
            case "1":
                eproject.setDcategory("信息技术");
                break;
            case "2":
                eproject.setDcategory("能源化工");
                break;
            case "3":
                eproject.setDcategory("生命科学");
                break;
            case "4":
                eproject.setDcategory("数理");
                break;
            default:
                eproject.setScategory("");
        }
        eproject.setTitle(project.getTitle());
        eproject.setHead(project.getHead());
        eproject.setParticipants(project.getParticipants());
        eproject.setOparticipants(project.getOparticipants());
        eproject.setPdeclaration(project.getPdeclaration());
        eproject.setGrade(project.getGrade());
        eproject.setBudget(project.getBudget());
        int i = projectMapper.updateByPrimaryKey(eproject);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult againProject(Project project) {
        Project eproject = projectMapper.selectByPrimaryKey(project.getId());
        switch (project.getScategory()){
            case "0":
                eproject.setScategory("哲学社会科学类社会调查报告及学术论文");
                break;
            case "1":
                eproject.setScategory("自然科学类学术论文");
                break;
            case "2":
                eproject.setScategory("发明制作类作品");
                break;
            case "3":
                project.setScategory("创作成果类作品");
                break;
            default:
                eproject.setScategory("");
        }
        switch (project.getDcategory()){
            case "0":
                eproject.setDcategory("机械与控制");
                break;
            case "1":
                eproject.setDcategory("信息技术");
                break;
            case "2":
                eproject.setDcategory("能源化工");
                break;
            case "3":
                eproject.setDcategory("生命科学");
                break;
            case "4":
                eproject.setDcategory("数理");
                break;
            default:
                eproject.setScategory("");
        }
        eproject.setTitle(project.getTitle());
        eproject.setHead(project.getHead());
        eproject.setParticipants(project.getParticipants());
        eproject.setOparticipants(project.getOparticipants());
        eproject.setGrade(project.getGrade());
        eproject.setBudget(project.getBudget());
        eproject.setAudit("未审核");
        int i = projectMapper.updateByPrimaryKey(eproject);
        return ScienceResult.ok();
    }
}
