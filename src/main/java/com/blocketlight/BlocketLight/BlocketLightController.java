package com.blocketlight.BlocketLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlocketLightController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/")
    public String loginGet(Model model) {
        List<Item> list = itemRepository.getList();
        model.addAttribute("items", list);

        return "index";
    }
}
