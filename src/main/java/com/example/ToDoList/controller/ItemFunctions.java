package com.example.ToDoList.controller;


import com.example.ToDoList.dto.ItemDto;
import com.example.ToDoList.dto.ItemUpdateDTO;
import com.example.ToDoList.dto.ItemViewDto;
import com.example.ToDoList.enums.StatusEnum;
import com.example.ToDoList.model.Item;
import com.example.ToDoList.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")

public class ItemFunctions {
//    @CrossOrigin(origins = "*")
    @Autowired
    private ItemService itemService;
    @GetMapping("/items/toDo")
    public ResponseEntity<List<ItemViewDto>> getAllItems(@RequestParam String status) {
        List<ItemViewDto> data = itemService.getItems(status);
        return ResponseEntity.ok(data);

    }
    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody ItemDto itemDto){
//        itemDto.setUsername("UserA");
        if(itemDto.getContent().length() <=1)
            return  ResponseEntity.badRequest().body("Content cannot be empty");
        itemDto.setStatus(StatusEnum.valueOf("PENDING"));
        Item addedItem = itemService.addItem(itemDto);
        return ResponseEntity.ok(addedItem.toString());

    }
    @PatchMapping("/items/update")
    public ResponseEntity<String>  updateItem(@RequestParam String id,@RequestBody ItemUpdateDTO status){
        if(id.length() ==0)
                return ResponseEntity.badRequest().body("Data missing");
        //Function call to update that specific

        itemService.updateStatus(status.getStatus(),id);
        return ResponseEntity.ok("Updated");
    }

}
