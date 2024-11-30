package org.example.books.controllers;

import org.example.books.models.Book;
import org.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getBooks(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/search")
    public String searchBooks(
            @RequestParam int views,
            @RequestParam String title,
            Model model) {
        List<Book> books = bookRepository.findByViewsAndTitle(views, title);
        model.addAttribute("books", books);
        return "books";
    }
}
