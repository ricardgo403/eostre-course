package com.example.springcourse.repositories;

import com.example.springcourse.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface IPublisherRepository extends CrudRepository<Publisher, Long> {

}
