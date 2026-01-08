package com.bajajbroking.trading.service;

import com.bajajbroking.trading.model.PortfolioHolding;
import com.bajajbroking.trading.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public void updateHolding(String symbol, int quantity, double price) {
        PortfolioHolding holding = portfolioRepository.findBySymbol(symbol);

        if (holding == null) {
            holding = new PortfolioHolding(
                    symbol,
                    quantity,
                    price,
                    quantity * price
            );
        } else {
            int totalQty = holding.getQuantity() + quantity;
            double avgPrice = ((holding.getAveragePrice() * holding.getQuantity()) +
                    (price * quantity)) / totalQty;

            holding.setQuantity(totalQty);
            holding.setAveragePrice(avgPrice);
            holding.setCurrentValue(totalQty * price);
        }

        portfolioRepository.save(holding);
    }

    public Collection<PortfolioHolding> getPortfolio() {
        return portfolioRepository.findAll();
    }
}
