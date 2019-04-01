package com.science.admin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.science.admin.mapper.CnoticeMapper;
import com.science.admin.mapper.DnoticeMapper;
import com.science.admin.model.Rcnotice;
import com.science.admin.pojo.Cnotice;
import com.science.admin.pojo.CnoticeExample;
import com.science.admin.pojo.Dnotice;
import com.science.admin.service.CnoticeService;
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
public class CnoticeServiceImpl implements CnoticeService {

    @Autowired
    private DnoticeMapper dnoticeMapper;

    @Autowired
    private CnoticeMapper cnoticeMapper;

    @Override
    public ScienceResult createCnotice(Cnotice cnotice,long pid) {
        Dnotice dnotice = dnoticeMapper.selectByPrimaryKey(pid);
        dnotice.setStatus((byte)1);
        dnoticeMapper.updateByPrimaryKey(dnotice);
        cnotice.setDnoticeId(pid);
        cnotice.setCreated(new Date());
        cnotice.setUpdated(new Date());
        //插入到数据库
        cnoticeMapper.insert(cnotice);
        return ScienceResult.ok();
    }

    @Override
    public LUDataGridResult getCnoticeList(int page, int limit) {
        CnoticeExample example = new CnoticeExample();
        //分页处理
        PageHelper.startPage(page, limit);
        //不加条件默认查询所有
        List<Cnotice> list = cnoticeMapper.selectByExampleWithBLOBs(example);
        List<Rcnotice> rlist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Cnotice cnotice:list){
            Rcnotice rcnotice=new Rcnotice();
            BeanUtils.copyProperties(cnotice,rcnotice);
            rcnotice.setCreports("<button " +
                    "class=\"layui-btn\"><a style=\"color: white;\" href=\"http://localhost:8080/admin/upload/download?filename="+rcnotice.getCreports()+"\">下载该通知结题报告书模板</a></button>");
            rcnotice.setDate(sdf.format(rcnotice.getCreated()));
            rlist.add(rcnotice);
        }
        //创建一个返回值对象
        LUDataGridResult result = new LUDataGridResult();
        result.setData(rlist);
        //取记录总条数
        PageInfo<Cnotice> pageInfo = new PageInfo<>(list);
        result.setCount(pageInfo.getTotal());
        result.setCode(0);
        result.setMsg("");
        return result;
    }

    @Override
    public Cnotice getCnotice(long id) {
        Cnotice cnotice = cnoticeMapper.selectByPrimaryKey(id);
        return cnotice;
    }

    @Override
    public ScienceResult delCnotice(long id) {
        int i = cnoticeMapper.deleteByPrimaryKey(id);
        return ScienceResult.ok();
    }

    @Override
    public ScienceResult editDnotice(Cnotice cnotice) {
        Cnotice ecnotice = cnoticeMapper.selectByPrimaryKey(cnotice.getId());
        ecnotice.setTitle(cnotice.getTitle());
        ecnotice.setContent(cnotice.getContent());
        ecnotice.setCreports(cnotice.getCreports());
        cnoticeMapper.updateByPrimaryKeyWithBLOBs(ecnotice);
        return ScienceResult.ok();
    }
}
