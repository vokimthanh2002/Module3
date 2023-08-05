package service;

import bean.Category;

import java.util.List;

public interface CategoryService {
    List<Category> finAll();
    Category finByID(String id);
}
