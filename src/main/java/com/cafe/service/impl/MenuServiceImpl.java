package com.cafe.service.impl;

import com.cafe.entity.Menu;
import com.cafe.repository.MenuRepository;
import com.cafe.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    MenuRepository menuRepository;

    @Override
    public List<Menu> getMenu() {
        List<Menu> menu = menuRepository.findByAvailability(true);
        if(menu == null || menu.isEmpty())
                return  List.of();
        return menu;
    }

    @Override
    public Menu getMenuById(Long id) {
        Menu menuItem = menuRepository.findByIdAndAvailability(id, true);
        if(menuItem == null)
            return  new Menu();
        return menuItem;
    }
}
