package com.iedu.project.controller;

import com.iedu.project.commons.TableData;
import com.iedu.project.controller.model.MovieExample;
import com.iedu.project.entity.MovieTv;
import com.iedu.project.service.DoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("logic/douban")
public class DoubanMovieController {
    @Autowired
    private DoubanService service;
    @RequestMapping("search")
    public TableData<MovieTv> searchMovieTvByExample(int page, int limit, MovieExample example){

        TableData<MovieTv> result=new TableData();

        List<MovieTv> movieTvList=service.searchByExample(example,page,limit);
        int allcount=service.searchByExampleCount(example);
        result.setCount(allcount);
        result.setData(movieTvList);
        result.setCode(0);
        result.setMsg("成功加载");

        return result;
    }
    @RequestMapping("/analysis/rating")
    public List<Map<String,String>> analysisRatingTotal(){ return service.RatingTotal();}
    @RequestMapping("/analysis/area")
    public List<Map<String,String>> analysisAreaTotal(){ return service.AreaTotal();}
    @RequestMapping("/analysis/lan")
    public List<Map<String,String>> analysisLanTotal(){ return service.LanTotal();}
    @RequestMapping("/analysis/EleTotal")
    public List<Map<String,String>> analysisEleMovieTotal(){ return service.EleTotal();}
}
