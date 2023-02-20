package com.library.repository;

import com.library.model.Author;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface AuthorRepository extends CrudRepository<Author, String> {
}
