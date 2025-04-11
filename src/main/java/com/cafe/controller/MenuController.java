package com.cafe.controller;

import com.cafe.entity.Menu;
import com.cafe.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    MenuService menuService;

    @GetMapping
    public List<Menu> getMenu(){
        return menuService.getMenu();
    }
}
