package com.example.ToDoList.service;


import com.example.ToDoList.dto.ItemDto;
import com.example.ToDoList.model.Item;
import com.example.ToDoList.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    public Item addItem(ItemDto dto){
        Item item = new Item();
        item.setDate(dto.getDate());
        item.setContent(dto.getContent());
        item.setUsername(dto.getUsername());
        item.setStatus(dto.getStatus());
        return itemRepository.addItem(item);
    }
}
