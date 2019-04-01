package com.science.admin.mapper;

import com.science.admin.pojo.Dnotice;
import com.science.admin.pojo.DnoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DnoticeMapper {
    long countByExample(DnoticeExample example);

    int deleteByExample(DnoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dnotice record);

    int insertSelective(Dnotice record);

    List<Dnotice> selectByExampleWithBLOBs(DnoticeExample example);

    List<Dnotice> selectByExample(DnoticeExample example);

    Dnotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dnotice record, @Param("example") DnoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") Dnotice record, @Param("example") DnoticeExample example);

    int updateByExample(@Param("record") Dnotice record, @Param("example") DnoticeExample example);

    int updateByPrimaryKeySelective(Dnotice record);

    int updateByPrimaryKeyWithBLOBs(Dnotice record);

    int updateByPrimaryKey(Dnotice record);
}