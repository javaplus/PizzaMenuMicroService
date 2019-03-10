package com.barry.demostuff.services;

import java.util.ArrayList;
import java.util.List;

import com.barry.demostuff.entities.MenuItem;

import org.springframework.stereotype.Service;

@Service
public class MenuService {
    
    public List<MenuItem> getAllMenuItems() {
        
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Plain Pizza", "Pizzas"));
        menuItems.add(new MenuItem("Mama Meatza Calzone", "Pizzas"));
        menuItems.add(new MenuItem("Lasagna", "Pastas"));

        return menuItems;

    }
}