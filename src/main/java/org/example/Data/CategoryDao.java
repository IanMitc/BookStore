package org.example.Data;

import org.example.Objects.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategories();

    Category getCategory(int id);
}
