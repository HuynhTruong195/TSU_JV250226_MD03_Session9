package ex.jv.repository.imp;

import ex.jv.model.Product;
import ex.jv.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImp implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> findAllProducts() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findProductById(String productId) {
        return entityManager.createQuery("from Product where productId like :productId", Product.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Boolean saveProduct(Product product) {
        try {
            entityManager.persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateProduct(Product product) {
        try {
            entityManager.merge(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean deleteProduct(String productId) {
        try {
            entityManager.remove(findProductById(productId));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findProductByName(String productName) {
        return entityManager.createQuery("from Product p where p.productName like :productName", Product.class)
                .setParameter("productName","%" +  productName + "%")
                .getResultList();
    }


}
