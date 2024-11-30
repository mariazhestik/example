package org.example.books.repository;

import org.example.books.models.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByViewsAndTitle(int views, String title);
}
