package com.example.ToDoList.dto;

import com.example.ToDoList.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ItemDto {
    private String username;
    private String content;
    private StatusEnum status;
    private Date date;
}
