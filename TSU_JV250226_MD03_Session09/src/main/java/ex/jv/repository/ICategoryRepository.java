package ex.jv.repository;

import ex.jv.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int catalogId);
    Boolean save(Category catalog);
    Boolean update(Category catalog);
    Boolean delete(int catalogId);

}
