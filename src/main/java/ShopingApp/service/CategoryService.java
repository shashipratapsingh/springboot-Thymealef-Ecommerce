package ShopingApp.service;

import ShopingApp.entity.Category;

import java.util.List;

public interface CategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategory();
    Boolean findByName(String name);
}
