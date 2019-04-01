package com.science.admin.service;

import com.science.admin.pojo.Cnotice;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.ScienceResult;

public interface CnoticeService {
    ScienceResult createCnotice(Cnotice cnotice,long pid);
    LUDataGridResult getCnoticeList(int page, int limit);
    Cnotice getCnotice(long id);
    ScienceResult delCnotice(long id);
    ScienceResult editDnotice(Cnotice cnotice);
}
