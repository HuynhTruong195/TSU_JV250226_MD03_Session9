package ex.jv.controller;

import ex.jv.model.Category;
import ex.jv.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("listCategory", listCategory);
        return "categoryList";
    }

    @GetMapping("/initAdd")
    private String addCatalog(Model model) {
        model.addAttribute("catalog", new Category());
        return "newCategory";
    }

    @PostMapping("/create")
    private String createCatalog(Category catalog) {
        Boolean result = categoryService.save(catalog);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    private String initUpdate(Model model, int catalogId) {
        Category catalog = categoryService.findById(catalogId);
        model.addAttribute("catalog", catalog);
        return "updateCategory";
    }

    @PostMapping("/update")
    private String updateCatalog(Category catalog) {
        Boolean result = categoryService.update(catalog);
        if (result) {
            return "redirect:findAll";
        } else
            return "error";
    }

    @GetMapping("/delete")
    public String deleteCatalog(int catalogId) {
        Boolean result = categoryService.delete(catalogId);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }
}
