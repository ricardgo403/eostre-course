package com.example.springcourse.repositories;

import com.example.springcourse.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book, Long> {
}
