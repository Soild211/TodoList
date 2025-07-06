package com.example.ToDoList.model;

import com.example.ToDoList.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String content;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private Date date;



}
