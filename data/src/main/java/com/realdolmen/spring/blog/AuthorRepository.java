package com.realdolmen.spring.blog;

import com.realdolmen.spring.blog.config.Author;
import com.realdolmen.spring.blog.config.JpaConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cerseilannister on 01/09/16.
 */
@Repository
@Transactional
@ContextConfiguration(classes = JpaConfig.class)
public interface AuthorRepository extends JpaRepository<Author, Integer>
{
    List<Author> getAuthorByNationality(String nationality);
    List<Author> getAuthorByKeyword(String keyword);
    List<Author> getAuthorByLastName(String lastName);

}
