package com.iedu.project.service.impl;

import com.iedu.project.controller.model.MovieTop250Example;
import com.iedu.project.entity.MovieTop250;
import com.iedu.project.mapper.MovieTop250Mapper;
import com.iedu.project.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ImdbServiceImpl implements ImdbService {

    @Autowired
    private MovieTop250Mapper mapper;

    public List<MovieTop250> searchByExample(MovieTop250Example example, int page, int limit){

        int begin =limit*(page-1);
        List<MovieTop250> result=mapper.selectByExample(example,begin,limit);

        return result;
    }
    public int searchByExampleCount(MovieTop250Example example){
        return mapper.selectExampleCount(example);
    }
    public List<Map<String,String>> last10YearsTotal(){
        return mapper.selectByYearGroup(20);
    }

    public List<Map<String, String>> RatingTotal() {
        return mapper.selectByRating();
    }
    public List<Map<String, String>> AreaTotal() {
        return mapper.selectByArea();
    }

    public List<Map<String, String>> EleTotal() {
        return mapper.selectByEle();
    }
}
