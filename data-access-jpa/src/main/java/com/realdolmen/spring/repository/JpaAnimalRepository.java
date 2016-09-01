package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaAnimalRepository implements AnimalRepository{
    // TODO: create a transactional repository bean from this class

    // TODO: inject a persistence context
    @PersistenceContext
    private EntityManager em;

    // TODO: implement AnimalRepository

    // TODO: implement findById()
    public Animal findById(int id)
    {
     return em.find(Animal.class, id);
    };

    // TODO: implement findAll()
    public List<Animal> findAll(){
       return em.createQuery("select f from Animal f order by f.name",Animal.class).getResultList();
    };

    // TODO: implement create()
    public void create(Animal animal)
    {
        em.persist(animal);
    };


    // TODO: implement update()
    public void update(Animal animal)
    {
        em.merge(animal);
    };

    // TODO: implement delete()
    public void remove(Animal animal)
    {
        em.remove(animal);
    };
}
