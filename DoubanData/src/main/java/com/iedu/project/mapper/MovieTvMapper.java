package com.iedu.project.mapper;

import com.iedu.project.controller.model.MovieExample;
import com.iedu.project.entity.MovieTv;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieTvMapper {
    int deleteByPrimaryKey(String id);

    int insert(MovieTv record);

    int insertSelective(MovieTv record);

    MovieTv selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MovieTv record);

    int updateByPrimaryKey(MovieTv record);

    List<MovieTv> selectAll(@Param("begin")int begin, @Param("limit") int limit);


    List<MovieTv> selectByExample(@Param("example")MovieExample example,
                                      @Param("begin")int begin,
                                      @Param("limit")int limit);
    int selectExampleCount(MovieExample example);
    int selectAllcount();

    List<Map<String, String>> selectByRating();
    List<Map<String, String>> selectByArea();

    List<Map<String, String>> selectByEle();

    List<Map<String, String>> selectByLan();
}