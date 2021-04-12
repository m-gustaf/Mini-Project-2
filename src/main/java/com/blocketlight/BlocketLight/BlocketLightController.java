package com.blocketlight.BlocketLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class BlocketLightController {

    @Autowired
    Repository repository;


    @GetMapping("/")
    public String loginGet(Model model) {
        List<Item> list =(List)repository.findAll();
        model.addAttribute("items", list);

        return "index";
    }

    @GetMapping("/{id}")
    public String detailPage(Model model, @PathVariable Integer id) {
        Item item = repository.findById(id).orElse(null);
        if (item == null) {
            return "redirect:/";
        }
        model.addAttribute("item", item);
        return "detailPage";
    }

    @GetMapping("/editItem/{id}")
    public String editItem(Model model, HttpSession session, @PathVariable Integer id){

        Item item = repository.findById(id).orElse(null);
        model.addAttribute("item", item);
        model.addAttribute("id", id);
        return "edititem";
    }

    @GetMapping("/listItems")
    public String listItems(Model model, HttpSession session) {
        List<Item> list =(List)repository.findAll();
        model.addAttribute("items", list);

        return "listItems";
    }

    @GetMapping("/searchItems")
    public String searchItems(Model model,@RequestParam String keyword) {
        List<Item> list =(List)repository.findByKeyword(keyword);
        model.addAttribute("items", list);
        model.addAttribute("keyword",keyword);
        return "listItems";
    }

    @GetMapping("/addItem")
    public String addItems(Model model, HttpSession session) {
        String username = (String)session.getAttribute("username");
        model.addAttribute("username", username);

        List<Item> list =(List)repository.findAll();

        model.addAttribute("items", list);
        Item item = new Item(null, null, null, null, null, true, null);
        model.addAttribute("item", item);
        return "additem";
    }

    @GetMapping("/delete/{id}")
    public  String delete(Model model,@PathVariable Integer id) {
        model.addAttribute("id",id);
        repository.deleteById(id);

        return "redirect:/listItems";
    }

    @PostMapping("/addItem")
    public String set(@ModelAttribute Item item) {
        repository.save(item);

        return "redirect:/listItems";
    }

    @PostMapping("/editItem")
    public String edit(@ModelAttribute Item item, @RequestParam Integer id) {
        repository.save(item);

        return "redirect:/listItems";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    /*
    @GetMapping("/forgot")
    public String forgot() {

        return "forgot";
    }
*/

}
