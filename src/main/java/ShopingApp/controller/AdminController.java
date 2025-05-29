package ShopingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String index() {
        return "admin/dashboard"; //return "Admin dashboard route works!"; resolves to src/main/resources/templates/admin/dashboard.html
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "admin/addProduct"; //return "Admin dashboard route works!"; resolves to src/main/resources/templates/admin/dashboard.html
    }
}

