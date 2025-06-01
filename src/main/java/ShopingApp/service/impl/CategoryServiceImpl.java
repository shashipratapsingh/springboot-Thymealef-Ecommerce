package ShopingApp.service.impl;

import ShopingApp.entity.Category;
import ShopingApp.repository.CategoryRepository;
import ShopingApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Boolean findByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
