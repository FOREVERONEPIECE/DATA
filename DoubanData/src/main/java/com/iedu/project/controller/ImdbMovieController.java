package com.iedu.project.controller;

import com.iedu.project.commons.TableData;
import com.iedu.project.controller.model.MovieTop250Example;
import com.iedu.project.entity.MovieTop250;
import com.iedu.project.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("logic/imdb")
public class ImdbMovieController{

    @Autowired
    private ImdbService service;
    @RequestMapping("search")
    public TableData<MovieTop250> searchMovieTop250ByExample(int page, int limit, MovieTop250Example example){

        TableData<MovieTop250> result=new TableData();

        List<MovieTop250> movieList=service.searchByExample(example,page, limit);
        int allcount=service.searchByExampleCount(example);
        result.setCount(allcount);
        result.setData(movieList);
        result.setCode(0);
        result.setMsg("成功加载");

        return result;
    }
    @RequestMapping("/analysis/10yearsTotal")
    public List<Map<String,String>> analysis10YearsMovieTotal(){ return service.last10YearsTotal();}
    @RequestMapping("/analysis/rating")
    public List<Map<String,String>> analysisRatingTotal(){ return service.RatingTotal();}
    @RequestMapping("/analysis/area")
    public List<Map<String,String>> analysisAreaTotal(){ return service.AreaTotal();}
    @RequestMapping("/analysis/EleTotal")
    public List<Map<String,String>> analysisEleMovieTotal(){ return service.EleTotal();}
}