package com.science.admin.controller;

import com.science.admin.pojo.Project;
import com.science.admin.pojo.Result;
import com.science.admin.service.ResultService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping(value="/declare")
    public ScienceResult createResult(Result cresult,long pid){
        ScienceResult result = resultService.createResult(cresult,pid);
        return result;
    }
    @GetMapping(value="/view")
    public LUDataGridResult viewResult(int page, int limit) {
        LUDataGridResult result=resultService.getResultList(page,limit);
        return result;
    }

    @GetMapping(value="/viewnresult")
    public LUDataGridResult viewNresult(int page, int limit,long userid) {
        LUDataGridResult result=resultService.getNresultList(page,limit,userid);
        return result;
    }

    @GetMapping(value="/viewsresult")
    public LUDataGridResult viewSresult(int page, int limit,long userid) {
        LUDataGridResult result=resultService.getSresultList(page,limit,userid);
        return result;
    }

    @GetMapping(value="/viewfresult")
    public LUDataGridResult viewFresult(int page, int limit,long userid) {
        LUDataGridResult result=resultService.getFresultList(page,limit,userid);
        return result;
    }

    @GetMapping(value="/adminviewnresult")
    public LUDataGridResult viewadminNresult(int page, int limit) {
        LUDataGridResult result=resultService.getadminNresultList(page,limit);
        return result;
    }
    @GetMapping(value="/adminviewsresult")
    public LUDataGridResult viewadminSresult(int page, int limit) {
        LUDataGridResult result=resultService.getadminSresultList(page,limit);
        return result;
    }
    @GetMapping(value="/adminviewfresult")
    public LUDataGridResult viewadminFresult(int page, int limit) {
        LUDataGridResult result=resultService.getadminFresultList(page,limit);
        return result;
    }

    @PostMapping("/passresult/{id}")
    public ScienceResult passresult(@PathVariable("id") long id){
        ScienceResult result = resultService.passResult(id);
        return result;
    }

    @PostMapping("/npassresult")
    public ScienceResult npassresult(Result result){
        ScienceResult nresult = resultService.npassResult(result);
        return nresult;
    }

    @PostMapping("/delnresult/{id}")
    public ScienceResult delNresult(@PathVariable("id") long id) {
        ScienceResult result = resultService.delResult(id);
        return result;
    }

    @PostMapping("/editnresult")
    public ScienceResult editNresult(Result result) {
        ScienceResult eresult = resultService.editResult(result);
        return eresult;
    }
    @PostMapping("/againresult")
    public ScienceResult againResult(Result result) {
        ScienceResult eresult = resultService.againResult(result);
        return eresult;
    }
}
