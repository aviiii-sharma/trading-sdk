package com.bajajbroking.trading.repository;

import com.bajajbroking.trading.model.PortfolioHolding;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PortfolioRepository {

    private final Map<String, PortfolioHolding> holdings = new HashMap<>();

    public PortfolioHolding save(PortfolioHolding holding) {
        holdings.put(holding.getSymbol(), holding);
        return holding;
    }

    public PortfolioHolding findBySymbol(String symbol) {
        return holdings.get(symbol);
    }

    public Collection<PortfolioHolding> findAll() {
        return holdings.values();
    }
}
