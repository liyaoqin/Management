package com.science.admin.controller;

import com.science.admin.pojo.Cnotice;
import com.science.admin.service.CnoticeService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cnotice")
public class CnoticeController {

    @Autowired
    private CnoticeService cnoticeService;

    @PostMapping(value="/release")
    public ScienceResult createCnotice(Cnotice cnotice,long pid) {
        ScienceResult result=cnoticeService.createCnotice(cnotice,pid);
        return result;
    }
    @GetMapping(value="/view")
    public LUDataGridResult viewCnotice(int page, int limit) {
        LUDataGridResult result=cnoticeService.getCnoticeList(page,limit);
        return result;
    }

    @PostMapping("/delcnotice/{id}")
    public ScienceResult delCnotice(@PathVariable("id") long id, Model model) {
        ScienceResult result = cnoticeService.delCnotice(id);
        return result;
    }
    @PostMapping("/editcnotice")
    public ScienceResult editCnotice(Cnotice cnotice) {
        ScienceResult result = cnoticeService.editDnotice(cnotice);
        return result;
    }
}
