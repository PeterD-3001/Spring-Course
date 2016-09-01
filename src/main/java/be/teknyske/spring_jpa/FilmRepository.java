package be.teknyske.spring_jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by cerseilannister on 01/09/16.
 */
@Repository
public class FilmRepository {
    @PersistenceContext
    private EntityManager em;

    public Film findById (int id){
        return em.find(Film.class, id);
    }

    public List<Film> findAll(){
        return em.createQuery("select f from Film f", Film.class).getResultList();
    }

    public void save (Film film){
     em.persist(film);
    }
}
