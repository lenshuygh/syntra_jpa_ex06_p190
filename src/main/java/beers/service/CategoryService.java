package beers.service;

import beers.model.Category;

import java.util.List;

public interface CategoryService{
    List<Category> getAllCategories();

    List<Category> getCategoriesByName(String name);
}
