package ad.Trivial.controllers.backend;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//http://localhost:8080/swagger-ui.html
@Controller
@RequestMapping("/admin")
@Hidden
public class AdminController {

    @GetMapping({"/","/dashboard"})
    public String dashboard(Model model) {
        return "admin/dashboard"; // Vista en templates/admin/dashboard.html
    }
}
