package com.blocketlight.BlocketLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
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

    @PostMapping("/login")
    public String loginPost(HttpSession session, @RequestParam String username, @RequestParam String password){
        boolean isLoggedIn = false;
        if (username.equals("admin") && password.equals("123")) {
            isLoggedIn = true;
            session.setAttribute("username", username);
            session.setAttribute("isLoggedIn", isLoggedIn);
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/{id}")
    public String detailPage(Model model, @PathVariable Integer id) {
        Item item = itemRepository.getItem(id);
        model.addAttribute("item", item);
        return "detailPage";
    }

    @GetMapping("/editItem/{id}")
    public String editItem(Model model, HttpSession session, @PathVariable Integer id){
        if ((Boolean)session.getAttribute("isLoggedIn") == null || (Boolean)session.getAttribute("isLoggedIn") == false ){
            return "login";
        }

        Item item = itemRepository.getItem(id);
        model.addAttribute("item", item);
        model.addAttribute("id", id);
        return "edititem";
    }

    @GetMapping("/listItems")
    public String listItems(Model model) {
        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);

        return "listItems";
    }

    @PostMapping("/searchItems")
    public String searchItems(Model model,@RequestParam String keyword) {
        List<Item> list = itemRepository.search(keyword);
        model.addAttribute("items", list);
        model.addAttribute("keyword",keyword);
        return "listItems";
    }


    @GetMapping("/addItem")
    public String addItems(Model model, HttpSession session) {
        String username = (String)session.getAttribute("username");
        model.addAttribute("username", username);

        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);
        Item item = new Item(null, null, null, null, null, true, null);
        model.addAttribute("item", item);
        return "addItem";
    }

    @GetMapping("/delete/{id}")
    public  String delete(Model model,@PathVariable Integer id) {
        model.addAttribute("id",id);
        itemRepository.deleteItem(id);

        return "redirect:/listItems";
    }

    @PostMapping("/addItem")
    public String set(@ModelAttribute Item item) {
        itemRepository.addItem(item);

        return "redirect:/listItems";
    }

    @PostMapping("/editItem")
    public String edit(@ModelAttribute Item item, @RequestParam Integer id) {
        System.out.println("ItemID getID: " + item.getId());
        System.out.println("ItemID requestparam:" + id);
        itemRepository.editItem(item);

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
