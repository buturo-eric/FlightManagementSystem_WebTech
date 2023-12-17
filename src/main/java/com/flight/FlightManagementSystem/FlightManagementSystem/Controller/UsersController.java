package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/signup")
    public String user(Model model){
        model.addAttribute("userModel",new UsersModel());
        return "signup";
    }

    @GetMapping("/login")
    public String userLogin(Model model){
        model.addAttribute("userModel",new UsersModel());

        return "login";
    }

    @GetMapping("/adminHome")
    public String adminHome(Model model) {
        // Logic for admin home page
        model.addAttribute("userModel",new UsersModel());
        return "adminHome";
    }

    @GetMapping("/userHome")
    public String userHome(Model model) {
        // Logic for user home page
        model.addAttribute("userModel",new UsersModel());
        return "userHome";
    }

    @PostMapping("createUser")
    public String createUser(@ModelAttribute("userModel") UsersModel usersModel, Model model){
        usersModel.setRole("user");
        usersService.addUsersModel(usersModel);
        model.addAttribute("signupSuccess", true);
        return "redirect:/home";
    }

    @PostMapping("loginUser")
    public String loginUser(@ModelAttribute("UsersModel") UsersModel usersModel, Model model, HttpSession session){
        UsersModel loginUser = usersService.userLogin(usersModel);

        if(loginUser != null){
            if ("admin".equals(loginUser.getRole())) {
                model.addAttribute("success", "Admin Logged in");
                session.setAttribute("userModel2",loginUser.getId());
                return "redirect:/adminHome";
            } else if ("user".equals(loginUser.getRole())) {
                model.addAttribute("success", "User Logged in");
                session.setAttribute("userModel2",loginUser.getId());
                return "redirect:/userHome";
            } else {
                model.addAttribute("error", "Role doesn't Exist");
                return "redirect:/login";
            }
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Logged out successfully");
        return "redirect:/home";
    }

}
