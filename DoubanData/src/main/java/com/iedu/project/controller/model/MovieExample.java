package com.iedu.project.controller.model;

import lombok.Data;

import java.util.Calendar;
@Data
public class MovieExample {
    private String name;
    private String actor;
    private String years;
    private String language;
    private String countrys;
    public int getBeginYear(){
        if (years!=null&&years.contains("-")){
            return Integer.parseInt(years.split("-")[0].trim());
        }
        return 1896;
    }
    public int getEndYear(){
        if (years !=null &&years.contains("-")&&years.split("-").length ==  2){
            return Integer.parseInt(years.split("-")[1].trim());

        }
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
