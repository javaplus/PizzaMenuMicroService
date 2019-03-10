package com.barry.demostuff.controllers;

import java.util.ArrayList;
import java.util.List;

import com.barry.demostuff.entities.MenuItem;
import com.barry.demostuff.services.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/menu/items")
    public List<MenuItem> getMenuItems(){

        
        return menuService.getAllMenuItems();
    }


}