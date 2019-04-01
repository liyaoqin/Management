package com.science.admin.service;

import com.science.admin.pojo.Result;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;

public interface ResultService {
    ScienceResult createResult(Result result,long pid);
    LUDataGridResult getResultList(int page, int limit);
    LUDataGridResult getNresultList(int page,int limit,long userid);
    LUDataGridResult getSresultList(int page,int limit,long userid);
    LUDataGridResult getFresultList(int page,int limit,long userid);
    LUDataGridResult getadminNresultList(int page,int limit);
    LUDataGridResult getadminSresultList(int page,int limit);
    LUDataGridResult getadminFresultList(int page,int limit);
    Result getResult(long id);
    ScienceResult delResult(long id);
    ScienceResult editResult(Result result);
    ScienceResult againResult(Result result);
    ScienceResult passResult(long id);
    ScienceResult npassResult(Result result);
}
