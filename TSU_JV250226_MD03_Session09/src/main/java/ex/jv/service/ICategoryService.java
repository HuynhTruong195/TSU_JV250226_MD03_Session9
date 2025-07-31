package ex.jv.service;

import ex.jv.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int catalogId);
    Boolean save(Category catalog);
    Boolean update(Category catalog);
    Boolean delete(int catalogId);
}
