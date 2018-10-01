package com.mr.assignment.mappers;

import com.mr.assignment.domain.NumberHistory;

import java.util.List;

public interface HistoryMapper {
    List<NumberHistory> findAllHistory();

    List<NumberHistory> findHistoryByNumber(int number);

    void insertHistory(NumberHistory numberHistory);
}
