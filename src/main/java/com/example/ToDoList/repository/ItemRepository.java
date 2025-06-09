package com.example.ToDoList.repository;

import com.example.ToDoList.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Add an Item
    public Item addItem(Item item){
        String sql = "INSERT INTO Item (username,content,status,date) VALUES (?,?,?,?)";
         jdbcTemplate.update(sql,item.getUsername(),item.getContent(),item.getStatus().name(),item.getDate());
        return item;
    }
    public Item alterItemStatus(Item item){
        String sql = "UPDATE  Item set status = ? where id =?";
        jdbcTemplate.update(sql,item.getStatus().name(),item.getId());
        return item;
    }
    public Item alterItemContent(Item item){
        String sql = "UPDATE  Item set content = ? where id =?";
        jdbcTemplate.update(sql,item.getContent(),item.getId());
        return item;
    }


}
