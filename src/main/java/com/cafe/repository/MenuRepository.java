package com.cafe.repository;

import com.cafe.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByAvailability(Boolean availability);
    Optional<Menu> findById(Long id);
}
