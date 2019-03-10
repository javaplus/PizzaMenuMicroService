package com.barry.demostuff.controllers;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.barry.demostuff.entities.MenuItem;
import com.barry.demostuff.services.MenuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MenuControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuService menuService;
    
    @Test
    public void testGETforMenuItemsReturnsOKResponse() throws Exception {
        
        mockMvc.perform(get("/menu/items"))
            .andExpect(status().isOk());
  
    }
    @Test
    public void testGETforMenuItemsReturnsMenuItemsJSON() throws Exception {
        
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("MyTestPizza", "Pizzas"));


        when(menuService.getAllMenuItems()).thenReturn(menuItems);

        mockMvc.perform(get("/menu/items"))
            .andExpect(status().isOk())        
            .andExpect(jsonPath("$.[0].name", equalToIgnoringCase("MyTestPizza")))
            .andExpect(jsonPath("$.[0].category", equalToIgnoringCase("Pizzas")));
            

    }


}