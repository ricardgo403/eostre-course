package com.example.springcourse.repositories;

import com.example.springcourse.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author, Long> {

}
