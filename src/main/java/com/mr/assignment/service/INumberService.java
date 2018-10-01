package com.mr.assignment.service;

import com.mr.assignment.domain.NumberHistory;
import com.mr.assignment.domain.PhoneNumber;

import java.util.List;

public interface INumberService {
    public List<PhoneNumber> getPhoneNumbers();

    public PhoneNumber getPhoneNumber(int number);

    public String createPhoneNumber(int number);

    public String suspendPhoneNumber(int number);

    public String activePhoneNumber(int number);

    public List<NumberHistory> getNumberHistories();

    public List<NumberHistory> getNumberHistoriesByNumber(int number);
}
