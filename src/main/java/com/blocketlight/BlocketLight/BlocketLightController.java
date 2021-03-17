package com.blocketlight.BlocketLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class BlocketLightController {


    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/")
    public String loginGet(Model model) {
        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);

        return "index";
    }

    @GetMapping("/{id}")
    public String detailPage(Model model, @PathVariable int id) {
        Item item = itemRepository.getItem(id);
        model.addAttribute("item", item);
        return "detailPage";
    }

    @GetMapping("/listItems")
    public String listItems(Model model) {
        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);

        return "listItems";
    }

    @GetMapping("/addItem")
    public String addItems(Model model) {
        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);
        Item item = new Item(0,null,null,1900,0,true,null);
        model.addAttribute("item",item);
        return "addItem";
    }

    @GetMapping("/delete/{id}")
    public  String delete(Model model,@PathVariable int id) {
        model.addAttribute("id",id);
        itemRepository.deleteItem(id);

        return "redirect:/listItems";
    }

    @PostMapping("/addItem")
    public String set(@ModelAttribute Item item) {
        itemRepository.addItem(item);

        return "redirect:/listItems";
    }

    @GetMapping("/login")
    public String login() {


        return "login";

    }


    @GetMapping("/forgot")
    public String forgot() {

        return "forgot";

    }
}
