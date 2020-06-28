package guru.springframework.springbootjokesapp.controllers;

import guru.springframework.springbootjokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    JokeService jokeService;

    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String getJokes(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "chucknorris";
    }

}
