package ex.jv.service.imp;

import ex.jv.model.Category;
import ex.jv.repository.ICategoryRepository;
import ex.jv.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int catalogId) {
        return categoryRepository.findById(catalogId);
    }

    @Override
    public Boolean save(Category catalog) {
        return categoryRepository.save(catalog);
    }

    @Override
    public Boolean update(Category catalog) {
        return categoryRepository.update(catalog);
    }

    @Override
    public Boolean delete(int catalogId) {
        return categoryRepository.delete(catalogId);
    }
}
