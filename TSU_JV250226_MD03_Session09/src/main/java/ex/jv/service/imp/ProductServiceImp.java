package ex.jv.service.imp;


import ex.jv.model.Product;
import ex.jv.repository.IProductRepository;
import ex.jv.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product findProductById(String productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public Boolean saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public Boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public Boolean deleteProduct(String productId) {
        return productRepository.deleteProduct(productId);
    }

    @Override
    public List<Product> findProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }
}
