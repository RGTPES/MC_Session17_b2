package org.example.session17_b2.service;

import org.example.session17_b2.entity.MenuItem;
import org.example.session17_b2.repository.MenuItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private static final Logger log = LoggerFactory.getLogger(RestaurantService.class);

    private final MenuItemRepository menuItemRepository;

    public RestaurantService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
    @Cacheable(value = "restaurantMenu", key = "#id")
    public List<MenuItem> getMenuByRestaurantId(Long id) {
        log.info(">>>  Truy vấn DB cho restaurantId={} - bắt đầu Thread.sleep(3000)...", id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread bị gián đoạn", e);
        }
        List<MenuItem> result = menuItemRepository.findByRestaurantId(id);
        log.info(">>> Truy vấn DB xong - trả về {} món, lưu vào cache key={}", result.size(), id);
        return result;
    }
}
