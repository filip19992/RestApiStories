package pl.filipwlodarczyk.stronaZeZdejciami.home;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TemplateController {

    @RequestMapping(value = "/home")
    public String getHelloPage() {
        return "home";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return "tu bedzie profil";
    }
}
