package com.iedu.project.service.impl;

import com.iedu.project.controller.model.MovieExample;
import com.iedu.project.entity.MovieTv;
import com.iedu.project.mapper.MovieTvMapper;
import com.iedu.project.service.DoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoubanServiceImpl implements DoubanService {
    @Autowired
    private MovieTvMapper mapper;

    public List<MovieTv> searchByExample(MovieExample example, int page, int limit){

        int begin =limit*(page-1);
        List<MovieTv> result=mapper.selectByExample(example,begin,limit);

        return result;
    }
    public int searchByExampleCount(MovieExample example){
        return mapper.selectExampleCount(example);
    }
    public List<Map<String, String>> RatingTotal() {
        return mapper.selectByRating();
    }
    public List<Map<String, String>> AreaTotal() {
        return mapper.selectByArea();
    }
    public List<Map<String, String>> LanTotal() {
        return mapper.selectByLan();
    }
    public List<Map<String, String>> EleTotal() {
        return mapper.selectByEle();
    }
}
