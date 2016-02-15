package com.shnarevich.controller;

import com.shnarevich.repository.ProductRepository;
import com.shnarevich.util.ExcelParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
public class FileUploadController {
    @Inject
    ProductRepository productRepository;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (!file.isEmpty()) try {
            ExcelParser.getProductsList(file).forEach(productRepository::save);
            productRepository.flush();
            return "redirect:/";

        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
            return "redirect:/";
        }
        else {
            redirectAttributes.addAttribute("message", "File is empty");
            return "redirect:/";
        }
    }
}
