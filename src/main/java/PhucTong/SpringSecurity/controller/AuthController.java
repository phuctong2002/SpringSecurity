package PhucTong.SpringSecurity.controller;

import PhucTong.SpringSecurity.dto.UserDto;
import PhucTong.SpringSecurity.entity.User;
import PhucTong.SpringSecurity.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        // create model object to  store data form
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if( existingUser != null && existingUser.getEmail() != null && existingUser.getEmail().isEmpty()){
            result.reject("email", null, "There is already an account registered with the same email");
        }
        if( result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users  = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
