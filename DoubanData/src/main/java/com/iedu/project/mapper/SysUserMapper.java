package com.iedu.project.mapper;

import com.iedu.project.controller.model.SysUserExample;
import com.iedu.project.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUid(String uid);
    List<SysUser> selectAll(@Param("begin")int begin,@Param("limit")int limit);
    List<SysUser> selectByExample(@Param("example")SysUserExample example,
                                  @Param("begin")int begin,
                                  @Param("limit")int limit);
    SysUser selectByLoginnameAndPassword(@Param("loginname")String loginname,
                                      @Param("password") String password);

    int selectExampleCount(SysUserExample example);
    int selectAllCount();

    
}

