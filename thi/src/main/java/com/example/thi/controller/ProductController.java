package com.example.thi.controller;

import com.example.thi.model.Category;
import com.example.thi.model.Product;
import com.example.thi.sevice.ICategoryService;
import com.example.thi.sevice.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("category")
    public List<Category> showCategory() {
        return iCategoryService.findAll();
    }

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> products = iProductService.findAllPr();
        model.addAttribute("product", products);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String CreateProduct( @ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable Integer id) {
        Product product = iProductService.findById(id);
        iProductService.delete(product);
        return "redirect:/";
    }

}
