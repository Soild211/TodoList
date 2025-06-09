package com.example.ToDoList.controller;


import com.example.ToDoList.dto.ItemDto;
import com.example.ToDoList.model.Item;
import com.example.ToDoList.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class itemFunctions {
    @Autowired
    private ItemService itemService;
    @GetMapping("/items/toDo")
    private String getAll(){
        return "Its is workinig";
    }
    @PostMapping("/addItem")
    private ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto){
        Item addedItem = itemService.addItem(itemDto);
        return ResponseEntity.ok(addedItem);
    }
}
