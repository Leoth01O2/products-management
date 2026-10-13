package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products = new LinkedHashMap<>();
    private static int nextId = 6;

    static {
        products.put(1, new Product(1, "Laptop Acer Nitro 5", 18000000, "Laptop gaming", "Acer"));
        products.put(2, new Product(2, "iPhone 15", 20000000, "Điện thoại thông minh", "Apple"));
        products.put(3, new Product(3, "Galaxy S24", 19000000, "Điện thoại Android", "Samsung"));
        products.put(4, new Product(4, "Redmi Note 13", 5500000, "Điện thoại tầm trung", "Xiaomi"));
        products.put(5, new Product(5, "MacBook Air M3", 27000000, "Laptop mỏng nhẹ", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        if (product.getId() == 0) {
            product.setId(nextId++);
        }
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        String keyword = name == null ? "" : name.trim().toLowerCase();

        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(keyword)) {
                result.add(product);
            }
        }
        return result;
    }
}
