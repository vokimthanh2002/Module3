package service.impl;

import bean.Category;
import repository.CategoryRepository;
import repository.impl.CategoryRepositoryImpl;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository = new CategoryRepositoryImpl();
    @Override
    public List<Category> finAll() {
        return repository.finAll();
    }

    @Override
    public Category finByID(String id) {
        return repository.finByID(id);
    }
}
