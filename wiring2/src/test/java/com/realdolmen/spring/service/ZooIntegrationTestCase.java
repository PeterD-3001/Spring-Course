package com.realdolmen.spring.service;

import com.realdolmen.spring.config.TestConfig;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryKibble;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by cda5732 on 14/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@ActiveProfiles("Test")
public class ZooIntegrationTestCase {

    @Autowired
    private Zoo zoo;

    @Autowired
    @Qualifier ("Kibble")
    private FoodRepository repository;

    @Test
    public void shouldHaveAntwerpZooPropertiesFilledIn() {
        assertThat(zoo.getName(), is("Antwerp Zoo"));
        // TODO assert the Zoo values come from the test properties

        assertThat(zoo.getMaxAnimalCount(), is(100));
        assertThat(zoo.getOwnerName(), is("ikke"));
        assertThat(zoo.getTicketPrice(), is(10));

    }

    @Test
    public void testFoodRepostory() {
        assertTrue(repository instanceof FoodRepositoryKibble);
    }
}
