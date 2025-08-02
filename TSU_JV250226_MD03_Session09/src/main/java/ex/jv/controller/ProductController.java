package ex.jv.controller;

import ex.jv.model.Category;
import ex.jv.model.Product;
import ex.jv.service.ICategoryService;
import ex.jv.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService iCategoryService;


    @GetMapping("/listproduct")
    public String listProduct(Model model) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/initCreate")
    public String initCreate(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryList);
        return "productCreate";
    }

    @PostMapping("/createProduct")
    public String createProduct(Product product) {
        Boolean result = productService.saveProduct(product);
        if (result) {
            return "redirect:listproduct";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public String initUpdate(Model model, String productId) {
        Product product = productService.findProductById(productId);
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        Boolean resultProduct = productService.updateProduct(product);
        if (resultProduct) {
            return "redirect:listproduct";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String delete(String productId) {
        Boolean result = productService.deleteProduct(productId);
        if (result) {
            return "redirect:listproduct";
        } else {
            return "error";
        }
    }

    @GetMapping("searchProductByName")
    public String searchProductByName(Model model, @RequestParam("keyword") String keyword) {
        List<Product> product;
        if (keyword != null &&  !keyword.trim().equals("")) {
            product = productService.findProductByName(keyword);
        }else {
            product = productService.findAllProducts();
        }
        model.addAttribute("products", product);
        model.addAttribute("keyword", keyword);
        return "productList";
    }
}
