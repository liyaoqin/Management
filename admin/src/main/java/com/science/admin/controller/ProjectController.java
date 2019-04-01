package com.science.admin.controller;

import com.science.admin.pojo.Project;
import com.science.admin.service.ProjectService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value="/declare")
    public ScienceResult createProject(Project project, long pid){
        ScienceResult result = projectService.createProject(project, pid);
        return result;
    }
    @GetMapping(value="/view")
    public LUDataGridResult viewProject(int page, int limit) {
        LUDataGridResult result=projectService.getProjectList(page,limit);
        return result;
    }

    @GetMapping(value="/viewnproject")
    public LUDataGridResult viewNproject(int page, int limit,long userid) {
        LUDataGridResult result=projectService.getNprojectList(page,limit,userid);
        return result;
    }

    @GetMapping(value="/adminviewnproject")
    public LUDataGridResult viewadminNproject(int page, int limit) {
        LUDataGridResult result=projectService.getadminNprojectList(page,limit);
        return result;
    }

    @GetMapping(value="/adminviewsproject")
    public LUDataGridResult viewadminSproject(int page, int limit) {
        LUDataGridResult result=projectService.getadminSprojectList(page,limit);
        return result;
    }

    @GetMapping(value="/adminviewfproject")
    public LUDataGridResult viewadminFproject(int page, int limit) {
        LUDataGridResult result=projectService.getadminFprojectList(page,limit);
        return result;
    }

    @GetMapping(value="/viewsproject")
    public LUDataGridResult viewSproject(int page, int limit,long userid) {
        LUDataGridResult result=projectService.getSprojectList(page,limit,userid);
        return result;
    }

    @GetMapping(value="/viewfproject")
    public LUDataGridResult viewFproject(int page, int limit,long userid) {
        LUDataGridResult result=projectService.getFprojectList(page,limit,userid);
        return result;
    }

    @PostMapping("/delnproject/{id}")
    public ScienceResult delnproject(@PathVariable("id") long id) {
        ScienceResult result = projectService.delProject(id);
        return result;
    }

    @PostMapping("/passproject/{id}")
    public ScienceResult passproject(@PathVariable("id") long id) {
        ScienceResult result = projectService.passProject(id);
        return result;
    }

    @PostMapping("/npassproject")
    public ScienceResult npassproject(Project project) {
        ScienceResult result = projectService.npassProject(project);
        return result;
    }

    @PostMapping("/editnproject")
    public ScienceResult editnproject(Project project) {
        ScienceResult result = projectService.editProject(project);
        return result;
    }

    @PostMapping("/againproject")
    public ScienceResult againProject(Project project) {
        ScienceResult result = projectService.againProject(project);
        return result;
    }
}
