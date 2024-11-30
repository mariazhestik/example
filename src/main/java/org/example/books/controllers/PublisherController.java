package org.example.books.controllers;

import org.example.books.models.Publisher;
import org.example.books.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/publishers")
    public String getPublishers(Model model) {
        Iterable<Publisher> publishers = publisherRepository.findAll();
        model.addAttribute("publishers", publishers);
        return "publishers"; // Назва HTML-шаблона, який ви створите
    }
}
