package com.science.admin.controller;

import com.science.admin.pojo.Dnotice;
import com.science.admin.pojo.Project;
import com.science.admin.service.DnoticeService;
import com.science.admin.service.ProjectService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dnotice")
public class DnoticeController {

    @Autowired
    private DnoticeService dnoticeService;

    @Autowired
    private ProjectService projectService;

    @PostMapping(value="/release")
    public ScienceResult createDnotice(Dnotice dnotice) {
        ScienceResult result=dnoticeService.createDnotice(dnotice);
        return result;
    }

    @GetMapping(value="/view")
    public LUDataGridResult viewDnotice(int page,int limit) {
        LUDataGridResult result=dnoticeService.getDnoticeList(page,limit);
        return result;
    }

    @GetMapping("/detaildnotice/{id}")
    public LUDataGridResult detailDnotice(@PathVariable("id") long id,Model model) {
        LUDataGridResult result = projectService.getdetailProjectList(id);
        return result;
    }

    @GetMapping(value="/viewndnotice")
    public LUDataGridResult viewNDnotice(int page,int limit) {
        LUDataGridResult result=dnoticeService.getNDnoticeList(page,limit);
        return result;
    }

    @GetMapping(value="/viewcdnotice")
    public LUDataGridResult viewCdnotice(int page,int limit) {
        LUDataGridResult result=dnoticeService.getCdnoticeList(page,limit);
        return result;
    }

    @GetMapping(value="/viewcdproject")
    public LUDataGridResult viewCdproject(int page,int limit) {
        LUDataGridResult result=dnoticeService.getCdprojectList(page,limit);
        return result;
    }


    @PostMapping("/deldnotice/{id}")
    public ScienceResult delDnotice(@PathVariable("id") long id) {
        ScienceResult result = dnoticeService.delDnotice(id);
        return result;
    }

    @PostMapping("/editdnotice")
    public ScienceResult editDnotice(Dnotice dnotice) {
        ScienceResult result = dnoticeService.editDnotice(dnotice);
        return result;
    }



}
