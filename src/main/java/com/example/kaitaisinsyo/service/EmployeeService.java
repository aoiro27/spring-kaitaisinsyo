package com.example.kaitaisinsyo.service;

import com.example.kaitaisinsyo.model.Employee;
import com.example.kaitaisinsyo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee getEmployee(String id){
        Map<String,Object> map = repository.find(id);
        Employee e = new Employee();
        e.setEmployeeId((String)map.get("id"));
        e.setEmployeeName((String)map.get("name"));
        e.setEmployeeAge((Integer)map.get("age"));
        return e;
    }

}
