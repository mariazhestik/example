package org.example.books.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String anons;

    private String description;  

    private int views;

    // Зв'язок багато до одного з таблицею Genre
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    // Зв'язок багато до одного з таблицею Publisher
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Зв'язок багато до багатьох з таблицею Author
    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    // Getters і Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getDescription() {  // Отримання опису книги
        return description;
    }

    public void setDescription(String description) {  // Встановлення опису книги
        this.description = description;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}