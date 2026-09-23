package org.example.session17_b2.controller;

import org.example.session17_b2.entity.MenuItem;
import org.example.session17_b2.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<List<MenuItem>> getMenu(@PathVariable Long restaurantId) {
        log.info("=== Nhận request GET /restaurants/{}/menu ===", restaurantId);
        long start = System.currentTimeMillis();

        List<MenuItem> menu = restaurantService.getMenuByRestaurantId(restaurantId);

        long elapsed = System.currentTimeMillis() - start;
        log.info("=== Trả về {} món ăn - thời gian xử lý: {} ms ===", menu.size(), elapsed);

        return ResponseEntity.ok(menu);
    }
}
