package pl.javastart.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.cookbook.entity.Recipe;
import pl.javastart.cookbook.repository.CookBookRepository;

import java.util.List;


@Controller
public class CookController {

    private CookBookRepository cookBookRepository;

    public CookController(CookBookRepository cookBookRepository) {
        this.cookBookRepository = cookBookRepository;
    }

    @GetMapping("/")
    public String start(@RequestParam(required = false) String title, Model model) {
        return "starter";
    }

    @GetMapping("/home")
    public String getRecipt(@RequestParam(required = false) String title, Model model) {
        List<Recipe> reciptes;
        if(title != null){
            reciptes = cookBookRepository.findAllByTitleContainsIgnoreCase(title);
        }else {
            reciptes = cookBookRepository.findAll();
        }
        model.addAttribute("reciptes", reciptes);
        return "home";
    }

    @GetMapping("/przepis")
    public String recipeInfo(@RequestParam long id, Model model) {
        Recipe przepis = cookBookRepository.getOne(id);
        model.addAttribute("przepis", przepis);
        return "przepisinfo";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe) {
        cookBookRepository.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam long id) {
        cookBookRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String addNewRecipe(Model model) {
        model.addAttribute("addRecipe", new Recipe());
        return "add";
    }

}
