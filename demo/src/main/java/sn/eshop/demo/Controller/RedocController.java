package sn.eshop.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedocController {
    @GetMapping("/redoc")
    public String redoc() {
        return "redirect:/redoc.html";
    }
}
