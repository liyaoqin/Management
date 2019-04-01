package com.science.admin.mapper;

import com.science.admin.pojo.Cnotice;
import com.science.admin.pojo.CnoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CnoticeMapper {
    long countByExample(CnoticeExample example);

    int deleteByExample(CnoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Cnotice record);

    int insertSelective(Cnotice record);

    List<Cnotice> selectByExampleWithBLOBs(CnoticeExample example);

    List<Cnotice> selectByExample(CnoticeExample example);

    Cnotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Cnotice record, @Param("example") CnoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Cnotice record, @Param("example") CnoticeExample example);

    int updateByExample(@Param("record") Cnotice record, @Param("example") CnoticeExample example);

    int updateByPrimaryKeySelective(Cnotice record);

    int updateByPrimaryKeyWithBLOBs(Cnotice record);

    int updateByPrimaryKey(Cnotice record);
}