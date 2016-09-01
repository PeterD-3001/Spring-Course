package be.teknyske.spring_jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerseilannister on 01/09/16.
 */
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private Integer id;

    private String title;
    private String description;

    @Column(name = "release_year")
    private int releaseYear;


    @ManyToMany (fetch= FetchType.EAGER)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )

    private List<Actor> actors = new ArrayList<>();

    public List<Actor> getActors() {
        return actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }



    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", actors=" + actors +
                '}';
    }
}



