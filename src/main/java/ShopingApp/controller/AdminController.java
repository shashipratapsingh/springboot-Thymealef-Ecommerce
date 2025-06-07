package ShopingApp.controller;

import ShopingApp.entity.Category;
import ShopingApp.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index() {
        return "admin/dashboard";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        //model.addAttribute("product", new Product()); // add this
        List<Category> categories = categoryService.findAllByName();
        System.out.println("Categories fetched from DB: " + categories);
        model.addAttribute("categories", categories);
        return "admin/addProduct";
    }


    @GetMapping("/addCategory")
    public String addCategory() {
        return "admin/addCategory";
    }
    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("messages", categoryService.getAllCategory());
        return "admin/category";
    }

    @GetMapping("/products")
    public String products() {
        return "admin/products";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(
            @ModelAttribute Category category,
            @RequestParam("file") MultipartFile file,
            HttpSession session
    ) {
        try {
            // Save uploaded file name
            String imageName = (file != null && !file.isEmpty()) ? file.getOriginalFilename() : "default.jpg";
            category.setImageName(imageName);

            Boolean existCategory = categoryService.findByName(category.getName());
            if (existCategory) {
                session.setAttribute("error", "Category Name Already Exists");
            } else {
                Category saved = categoryService.saveCategory(category);
                if (saved == null) {
                    session.setAttribute("error", "Internal Server Error");
                } else {
                    session.setAttribute("succMsg", "Successfully Saved");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Exception occurred: " + e.getMessage());
        }
        return "redirect:/admin/category";
    }

}


