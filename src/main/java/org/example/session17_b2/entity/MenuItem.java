package org.example.session17_b2.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu_items")
public class MenuItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "price")
    private Integer price;

    public MenuItem() {}

    public MenuItem(Long id, Long restaurantId, String dishName, Integer price) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.dishName = dishName;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    public String getDishName() { return dishName; }
    public void setDishName(String dishName) { this.dishName = dishName; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    @Override
    public String toString() {
        return "MenuItem{id=" + id + ", restaurantId=" + restaurantId
                + ", dishName='" + dishName + "', price=" + price + "}";
    }
}
