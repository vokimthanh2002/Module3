package repository.impl;

import bean.Category;
import repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepositoryImpl implements CategoryRepository {
    private  static Map<String,Category> categoryMap;
    static {
        categoryMap = new HashMap<>();
        categoryMap.put("CT001", new Category("CT001","Sach giao khoa"));
        categoryMap.put("CT002", new Category("CT002","Sach tieng anh"));
        categoryMap.put("CT003", new Category("CT003","Sach lich su"));
        categoryMap.put("CT004", new Category("CT004","Sach dia ly"));
        categoryMap.put("CT005", new Category("CT005","Sach ngu van"));
    }
    @Override
    public List<Category> finAll() {
        return  new ArrayList<>(categoryMap.values());
    }

    @Override
    public Category finByID(String id) {
        return categoryMap.get(id);
    }


}
