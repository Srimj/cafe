package com.cafe.service.impl;

import com.cafe.entity.Menu;
import com.cafe.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public List<Menu> getMenu() {
        return List.of();
    }
}
