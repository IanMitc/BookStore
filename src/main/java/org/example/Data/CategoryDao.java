package org.example.Data;

import org.example.Data.Exceptions.CategoryNotFoundException;
import org.example.Objects.Category;

public interface CategoryDao {

    Category getCategory(int id) throws CategoryNotFoundException;
}
