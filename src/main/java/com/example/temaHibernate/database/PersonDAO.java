package com.example.temaHibernate.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonDAO extends CrudRepository<Person, Integer> {
    //List<Person>findByCategory(String textCategory);
}
