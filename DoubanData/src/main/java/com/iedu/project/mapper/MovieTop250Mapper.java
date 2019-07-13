package com.iedu.project.mapper;

import com.iedu.project.controller.model.MovieTop250Example;
import com.iedu.project.entity.MovieTop250;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieTop250Mapper {
    int deleteByPrimaryKey(String id);

    int insert(MovieTop250 record);

    int insertSelective(MovieTop250 record);

    MovieTop250 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MovieTop250 record);

    int updateByPrimaryKey(MovieTop250 record);
    List<MovieTop250> selectAll(@Param("begin")int begin, @Param("limit") int limit);


    List<MovieTop250> selectByExample(@Param("example")MovieTop250Example example,
                                      @Param("begin")int begin,
                                      @Param("limit")int limit);
    int selectExampleCount(MovieTop250Example example);
    int selectAllcount();
    List<Map<String,String>> selectByYearGroup(int year);
    List<Map<String,String>> selectByRating();

    List<Map<String, String>> selectByArea();

    List<Map<String, String>> selectByEle();
}