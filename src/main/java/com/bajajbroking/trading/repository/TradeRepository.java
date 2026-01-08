package com.bajajbroking.trading.repository;

import com.bajajbroking.trading.model.Trade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TradeRepository {

    private final List<Trade> trades = new ArrayList<>();

    public Trade save(Trade trade) {
        trades.add(trade);
        return trade;
    }

    public List<Trade> findAll() {
        return trades;
    }
}
