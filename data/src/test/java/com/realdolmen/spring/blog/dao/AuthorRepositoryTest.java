package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.AuthorRepository;
import com.realdolmen.spring.blog.config.Author;
import com.realdolmen.spring.blog.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by cda5732 on 14/04/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")


// TODO Activate the test profile
// TODO Activate transactions
public class AuthorRepositoryTest {

    // TODO wire in the repository
    @Autowired
    private AuthorRepository authRepository;


    // TODO add unit tests to test the repository
    @Test
    public void testcreate() throws Exception {

        Author newAuthor = new Author("voornaam","familienaam","Belg", "Fiction");
        long before = authRepository.count();
        authRepository.save(newAuthor);
        assertNotNull(newAuthor.getId());
        assertEquals(before + 1, authRepository.count());
    }

    // TODO add unit tests to test the repository
    @Test
    public void testGetAuthorByNationality() throws Exception {
        Author Author1 = new Author("Paul","Fantast","Belg", "Fiction");
        authRepository.save(Author1);
        Author Author2 = new Author("Jan","Kribbelaar","Hollander", "Horror");
        authRepository.save(Author2);
        Author Author3 = new Author("Miet","Schrijvelaar","Hollander", "Verhaal");
        authRepository.save(Author3);

        List<Author> lijstje = authRepository.getAuthorByNationality("Hollander");
        for (Author auteur : lijstje)
            {
                System.out.println(auteur);
            }
        assertEquals(2, lijstje.size());
    }
}
