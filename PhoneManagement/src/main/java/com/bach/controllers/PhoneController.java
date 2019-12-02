package com.bach.controllers;

import com.bach.models.Category;
import com.bach.models.Phone;
import com.bach.service.CategoryService;
import com.bach.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/phones")
    public ModelAndView listPhone(@RequestParam("s")Optional<String> s, @PageableDefault(size = 5, sort = "price") Pageable pageable){
        Page<Phone> phones;
        if(s.isPresent()){
            phones = phoneService.findAllByNameContaining(s.get(), pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    @GetMapping("/create-phone")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("/create-phone")
    public ModelAndView saveMaterial(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("material", new Phone());
        modelAndView.addObject("message","Them so dien thoai thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit-phone/{id}")
    public ModelAndView showEditMaterial(@PathVariable Long id) {
        Phone phone = phoneService.findById(id);
        if (phone!= null) {
            ModelAndView modelAndView = new ModelAndView("/hone/edit");
            modelAndView.addObject("phone",phone);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-phone")
    public ModelAndView updateMaterial(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/edit");
        modelAndView.addObject("phone",phone);
        modelAndView.addObject("message", "Cap nhat so dien thoai thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete-phone/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Phone phone = phoneService.findById(id);
        if(phone != null) {
            ModelAndView modelAndView = new ModelAndView("/phone/delete");
            modelAndView.addObject("phone", phone);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-phone")
    public String deleteMaterial(@ModelAttribute("material") Phone phone){
        phoneService.remove(phone.getId());
        return "redirect:phones";
    }
}
