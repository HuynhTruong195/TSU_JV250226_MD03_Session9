package ex.jv.repository.imp;

import ex.jv.model.Category;
import ex.jv.repository.ICategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepositoryImp implements ICategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    public Category findById(int catalogId) {
        return entityManager.find(Category.class, catalogId);
    }

    @Override
    @Transactional
    public Boolean save(Category catalog) {
        try {
            entityManager.persist(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean update(Category catalog) {
        try {
            entityManager.merge(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean delete(int catalogId) {
        try {
            Category catalog = entityManager.find(Category.class, catalogId);
            entityManager.remove(catalog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
