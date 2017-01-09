package ua.com.codespace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.codespace.model.Product;
import ua.com.codespace.repository.CategoryRepository;
import ua.com.codespace.repository.ProductRepository;

import java.util.List;

/**
 * Created by devT on 08.01.2017.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping
    public String getProducts(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productRepository.findOne(id));
        return "product";
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    //For upload JSP form
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String from(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        return "addProduct";
    }

    @RequestMapping(value = "/del/{id}")
    public String removeProduct(@PathVariable Long id){
        productRepository.delete(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productRepository.findOne(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "addProduct";
    }
}
