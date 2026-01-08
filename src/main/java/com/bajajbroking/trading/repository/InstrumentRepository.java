package com.bajajbroking.trading.repository;

import com.bajajbroking.trading.model.Instrument;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentRepository {

    private final List<Instrument> instruments = new ArrayList<>();

    public InstrumentRepository() {
        // Pre-load some instruments
        instruments.add(new Instrument("TCS", "NSE", "EQUITY", 3850.50));
        instruments.add(new Instrument("INFY", "NSE", "EQUITY", 1560.75));
        instruments.add(new Instrument("RELIANCE", "NSE", "EQUITY", 2910.20));
    }

    public List<Instrument> findAll() {
        return instruments;
    }
}
