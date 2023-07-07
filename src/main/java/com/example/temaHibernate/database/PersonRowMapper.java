package com.example.temaHibernate.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person=new Person();
        person.setId(rs.getInt("id"));
        person.setPrenumele(rs.getString("prenumele"));
        person.setVarsta(rs.getInt("varsta"));
        person.setAdresa(rs.getString("adresa"));
        person.setSalariu(rs.getDouble("salariu"));
        return person;
    }
}
