package be.teknyske.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cerseilannister on 31/08/16.
 */
@Repository
public class FilmRepository {

    @Autowired
    private JdbcTemplate jt;

    public List<Film> findAllFilms()
    {

        return jt.query("SELECT * FROM film", new RowMapper<Film>() {
            @Override
            public Film mapRow(ResultSet rs, int i) throws SQLException {
                return new Film(
                        rs.getString("title"),
                        rs.getInt("release_year"),
                        rs.getString("description")
                            );
            }
        });

//        return jt.query("SELECT * FROM film", (rs,rowNum) ->
//            {
//                return
//                    new Film(
//                        rs.getString("title"),
//                        rs.getInt("release_year"),
//                        rs.getString("description")
//                            );
//            });
    }
}
