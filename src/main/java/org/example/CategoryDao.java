package org.example;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategories();

    Category getCategory(int id);
}
