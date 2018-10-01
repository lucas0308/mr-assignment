package com.mr.assignment.mappers;

import com.mr.assignment.domain.PhoneNumber;

import java.util.List;

public interface NumberMapper {
    List<PhoneNumber> findAllNumbers();

    PhoneNumber findNumberById(int id);

    void insertNumber(PhoneNumber phoneNumber);

    void updateNumber(PhoneNumber phoneNumber);
}
