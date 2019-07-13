package com.iedu.project.service;

import com.iedu.project.controller.model.MovieExample;
import com.iedu.project.entity.MovieTv;

import java.util.List;
import java.util.Map;

public interface DoubanService {
    List<MovieTv> searchByExample(MovieExample example, int page, int limit);

    int searchByExampleCount(MovieExample example);

    List<Map<String, String>> RatingTotal();

    List<Map<String, String>> AreaTotal();

    List<Map<String, String>> EleTotal();

    List<Map<String, String>> LanTotal();
}
