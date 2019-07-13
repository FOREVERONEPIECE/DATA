package com.iedu.project.service;

import com.iedu.project.controller.model.MovieTop250Example;
import com.iedu.project.entity.MovieTop250;

import java.util.List;
import java.util.Map;

public interface ImdbService {
    List<MovieTop250> searchByExample(MovieTop250Example example,int page,int limit);
    int searchByExampleCount(MovieTop250Example example);

    List<Map<String, String>> last10YearsTotal();

    List<Map<String, String>> RatingTotal();

    List<Map<String, String>> AreaTotal();

    List<Map<String, String>> EleTotal();
}
