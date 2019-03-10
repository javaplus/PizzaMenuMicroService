package com.barry.demostuff.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MenuItem {
    

    @Getter
    @Setter
    private String name = "Uber Pizza";

    @Getter
    @Setter
    private String category = "Pizzas";

}