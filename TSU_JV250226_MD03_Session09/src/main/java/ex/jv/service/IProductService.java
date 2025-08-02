package ex.jv.service;

import ex.jv.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();
    Product findProductById(String productId);
    Boolean saveProduct(Product product);
    Boolean updateProduct(Product product);
    Boolean deleteProduct(String productId);
    List<Product> findProductByName(String productName);
}
