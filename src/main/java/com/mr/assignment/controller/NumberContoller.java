package com.mr.assignment.controller;

import com.mr.assignment.domain.NumberHistory;
import com.mr.assignment.domain.PhoneNumber;
import com.mr.assignment.service.INumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NumberContoller {
    @Autowired
    INumberService service;

    @RequestMapping("/rest/numbers")
    public List<PhoneNumber> getNumbers(){

        return service.getPhoneNumbers();
    }

    @RequestMapping("/rest/getNumber")
    public PhoneNumber getNumber(Integer number){

        return service.getPhoneNumber(number);
    }

    @RequestMapping("/rest/addNumber")
    public String addNumber(Integer number){

        return service.createPhoneNumber(number);
    }

    @RequestMapping("/rest/suspendNumber")
    public String suspendNumber(Integer number){

        return service.suspendPhoneNumber(number);
    }

    @RequestMapping("/rest/activeNumber")
    public String activeNumber(Integer number){

        return service.activePhoneNumber(number);
    }

    @RequestMapping("/rest/histories")
    public List<NumberHistory> histories(){

        return service.getNumberHistories();
    }

    @RequestMapping("/rest/getNumberHistories")
    public List<NumberHistory> getNumberHistories(Integer number){

        return service.getNumberHistoriesByNumber(number);
    }
}
