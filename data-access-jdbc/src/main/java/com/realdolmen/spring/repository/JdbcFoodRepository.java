package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// TODO: Implement the FoodRepository
@Repository
public class JdbcFoodRepository implements FoodRepository {

    // TODO: Inject a reference to your JdbcTemplate
    @Autowired
    private JdbcTemplate jt;

    // TODO: Implement findAllFood() and create a RowMapper to make this easier!
    // TODO: Implement findFoodById() and reuse your RowMapper
    // TODO: Implement findFoodForAnimalType()
    // TODO: Implement removeFood()

    private RowMapper<Food> frm = (rs,i) ->
    {
        Food f = null;

        // Prep Common fields
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int calories = rs.getInt("calories");

        if (rs.getString("food_class").equals("MeatyFood"))
        {
            f = new MeatyFood
                    (
                     id, name, calories,
                     MeatyFood.Type.valueOf(rs.getString("meaty_food_type"))
                    );
        }
        else
        {
            f = new VegiFood(
                    id, name , calories,
                    rs.getBoolean("fruit"),
                    rs.getBoolean("vegetables")

                            );
        }
        return f;

    };

    @Override
    public Food findFoodById(int id) {
      return jt.queryForObject("SELECT * FROM food WHERE id=?",frm, id);
    }

    @Override
    public List<Food> findAllFood()
    {
        return jt.query("SELECT * FROM food", frm);
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return null;
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {


    }

    @Override
    public void removeFood(Food food) {
        jt.execute("DELETE FROM food WHERE id=?", frm, food.getId());




    }



}
