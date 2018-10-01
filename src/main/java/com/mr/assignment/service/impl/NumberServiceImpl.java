package com.mr.assignment.service.impl;

import com.mr.assignment.constant.NumberConstant;
import com.mr.assignment.domain.NumberHistory;
import com.mr.assignment.domain.PhoneNumber;
import com.mr.assignment.mappers.HistoryMapper;
import com.mr.assignment.mappers.NumberMapper;
import com.mr.assignment.service.INumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberServiceImpl implements INumberService {
    @Autowired
    NumberMapper mapper;

    @Autowired
    HistoryMapper historyMapper;

    public List<PhoneNumber> getPhoneNumbers(){

        return mapper.findAllNumbers();
    }

    public PhoneNumber getPhoneNumber(int number){

        return mapper.findNumberById(number);
    }

    public String createPhoneNumber(int number){
        PhoneNumber pn = this.getPhoneNumber(number);
        if(this.isNumberExist(number)){
            return "The number already exist!";
        }

        PhoneNumber phoneNumber = this.generateNumber(number, null);
        mapper.insertNumber(phoneNumber);

        this.createHistory(number, "Number created");

        return "Created success!";
    }

    private PhoneNumber generateNumber(int number, String status){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(number);
        phoneNumber.setStatus(status);

        return phoneNumber;
    }

    private NumberHistory generateHistory(int number, String description){
        NumberHistory history = new NumberHistory();
        history.setNumber(number);
        history.setDescription(description);

        return history;
    }

    private boolean isNumberExist(int number){
        PhoneNumber pn = this.getPhoneNumber(number);
        if(pn != null){
            return true;
        }
        return false;
    }

    public String suspendPhoneNumber(int number){
        if(!this.isNumberExist(number)){
            return "The number is not exist!";
        }

        PhoneNumber phoneNumber = this.generateNumber(number, NumberConstant.STATUS_SUSPENDED);
        mapper.updateNumber(phoneNumber);

        this.createHistory(number, "Number suspended");

        return "The number has been suspended!";
    }

    public String activePhoneNumber(int number){
        if(!this.isNumberExist(number)){
            return "The number is not exist!";
        }

        PhoneNumber phoneNumber = this.generateNumber(number, NumberConstant.STATUS_ACTIVATED);
        mapper.updateNumber(phoneNumber);

        this.createHistory(number, "Number activated");

        return "The number has been activated!";
    }

    private void createHistory(int number, String description){
        NumberHistory history = this.generateHistory(number, description);
        historyMapper.insertHistory(history);
    }

    public List<NumberHistory> getNumberHistories(){
        return historyMapper.findAllHistory();
    }

    public List<NumberHistory> getNumberHistoriesByNumber(int number){
        return historyMapper.findHistoryByNumber(number);
    }
}
