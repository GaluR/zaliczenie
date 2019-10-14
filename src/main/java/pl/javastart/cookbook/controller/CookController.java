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
    public String getRecipt(Model model) {
        List<Recipe> reciptes = cookBookRepository.findAll();
        model.addAttribute("reciptes", reciptes);
        model.addAttribute("addRecipe", new Recipe());
        return "home";
    }

    @GetMapping("/przepis")
    public String taskInfo(@RequestParam long id, Model model) {
        Recipe przepis = cookBookRepository.getOne(id);
        model.addAttribute("przepis", przepis);
        return "przepisinfo";
    }

    @PostMapping("/add")
    public String addTask(Recipe recipe) {
        cookBookRepository.save(recipe);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteRecipe(@RequestParam long Id) {
        cookBookRepository.deleteById(Id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String addNewRecipe(Model model) {
        model.addAttribute("addRecipe", new Recipe());
        return "add";
    }

    @PostMapping("/deleteall")
    public String deleteAllRecipes() {
        cookBookRepository.deleteAll();
        return "redirect:/";
    }
}
