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
        instruments.add(new Instrument("BTCUSDT", "BINANCE", "CRYPTO", 43250.75));
        instruments.add(new Instrument("ETHUSDT", "BINANCE", "CRYPTO", 2285.40));
        instruments.add(new Instrument("SOLUSDT", "BINANCE", "CRYPTO", 98.65));

    }

    public List<Instrument> findAll() {
        return instruments;
    }
}
