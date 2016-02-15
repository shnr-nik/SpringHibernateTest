package com.shnarevich.controller;

import com.shnarevich.model.Product;
import com.shnarevich.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
public class HomeController {
    @Inject
    ProductRepository productRepository;

    @RequestMapping("/")
    public String index(@RequestParam(value="message", required=false) String message, Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("message", message);
        return "index";
    }
}
