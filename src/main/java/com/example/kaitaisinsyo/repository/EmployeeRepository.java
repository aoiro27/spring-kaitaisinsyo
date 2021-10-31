package com.example.kaitaisinsyo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jt;

    public Map<String, Object> find(String id){
        String query = "SELECT *"
                + " FROM employee"
                +" WHERE id=?";

        Map<String,Object> employee = jt.queryForMap(query,id);
        return employee;

    }

}
