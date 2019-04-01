package com.science.admin.service;


import com.science.admin.pojo.Project;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;

import java.util.List;

public interface ProjectService {
    ScienceResult createProject(Project project, long pid);
    LUDataGridResult getProjectList(int page, int limit);
    LUDataGridResult getdetailProjectList(long id);
    LUDataGridResult getNprojectList(int page,int limit,long userid);
    LUDataGridResult getadminNprojectList(int page,int limit);
    LUDataGridResult getadminSprojectList(int page,int limit);
    LUDataGridResult getadminFprojectList(int page,int limit);
    LUDataGridResult getSprojectList(int page,int limit,long userid);
    LUDataGridResult getFprojectList(int page,int limit,long userid);
    Project getProject(long id);
    ScienceResult delProject(long id);
    ScienceResult passProject(long id);
    ScienceResult npassProject(Project project);
    ScienceResult editProject(Project project);
    ScienceResult againProject(Project project);
}
