package repository;

import bean.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> finAll();
    Category finByID(String id);
}
