package com.example.ToDoList.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ItemViewDto {
    private Long id;
    private String username;
    private String content;
    private Date date;
}
