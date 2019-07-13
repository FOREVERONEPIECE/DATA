package com.iedu.project.commons;

import lombok.Data;
import java.util.List;

@Data
public class TableData<T> {

    private int code;
    private String msg;
    private int count;
    private List<T>data;
}
