package com.cafe.service;

import com.cafe.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu();
    Menu getMenuById(Long id);
}
