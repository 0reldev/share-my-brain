package com.wildcodeschool.sharemybrain.controller;

import com.wildcodeschool.sharemybrain.repository.AvatarRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    UserRepository userRepository = new UserRepository();
    AvatarRepository avatarRepository = new AvatarRepository();

    @GetMapping("/")
    public String index(Model model, @CookieValue(value = "username", defaultValue = "Atta") String username) {
        Boolean logged;
        if (username.equals("Atta")) {
            logged = false;
        } else {
            logged = true;
            int idAvatar = userRepository.findAvatar(username);
            model.addAttribute("username", username);
            model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar));
        }
        model.addAttribute("logged", logged);
        return "index";
    }
}
