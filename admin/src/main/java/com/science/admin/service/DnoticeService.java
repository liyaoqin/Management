package com.science.admin.service;

import com.science.admin.pojo.Dnotice;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;

public interface DnoticeService {
    ScienceResult createDnotice(Dnotice dnotice);
    LUDataGridResult getDnoticeList(int page, int limit);
    LUDataGridResult getNDnoticeList(int page, int limit);
    Dnotice getDnotice(long id);
    ScienceResult delDnotice(long id);
    ScienceResult editDnotice(Dnotice dnotice);
    LUDataGridResult getCdnoticeList(int page, int limit);
    LUDataGridResult getCdprojectList(int page, int limit);
}
