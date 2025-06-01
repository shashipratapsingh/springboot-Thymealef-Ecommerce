package ShopingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "admin/dashboard";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "admin/addProduct";
    }

    @GetMapping("/addCategory")
    public String addCategory() {
        return "admin/addCategory";
    }
    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }

    @GetMapping("/products")
    public String products() {
        return "admin/products";
    }
}


