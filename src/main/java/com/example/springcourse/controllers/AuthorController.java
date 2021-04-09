package com.example.springcourse.controllers;

import com.example.springcourse.repositories.IAuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final IAuthorRepository authorRepository;

    public AuthorController(IAuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
}
