package com.example.ToDoList.repository;

import com.example.ToDoList.dto.ItemUpdateDTO;
import com.example.ToDoList.dto.ItemViewDto;
import com.example.ToDoList.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void alterItemStatus(String status , int id){
        String sql = "UPDATE  Item set status = ? where id =?";
        jdbcTemplate.update(sql,status,id);
//        return item;
    }
    public Item alterItemContent(Item item){
        String sql = "UPDATE  Item set content = ? where id =?";
        jdbcTemplate.update(sql,item.getContent(),item.getId());
        return item;
    }
    public List<ItemViewDto> getAllItemsofType(String type){
        String sql = "SELECT * from item where status = ? ";
        return jdbcTemplate.query(sql,new Object[]{type.toUpperCase()},(rs, rowNum)->
                new ItemViewDto(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("content"),
                        rs.getDate("date")
                ));
    }


}
