package ua.com.codespace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by devT on 08.01.2017.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message", "1234567890");
        return "index";
    }
}
