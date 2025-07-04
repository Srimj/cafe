package com.cafe.service.impl;

import com.cafe.entity.Menu;
import com.cafe.exception.CafeCustomException;
import com.cafe.repository.MenuRepository;
import com.cafe.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    @Cacheable(value = "menuList")
    public List<Menu> getMenu() {
        List<Menu> menu = menuRepository.findByAvailability(true);
        if(menu == null || menu.isEmpty())
                return  List.of();
        return menu;
    }

    @Override
    public Menu checkIfItemExists(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new CafeCustomException(100, "Item doesnt exist"));
    }
}
