package com.bajajbroking.trading.controller;

import com.bajajbroking.trading.model.PortfolioHolding;
import com.bajajbroking.trading.service.PortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public Collection<PortfolioHolding> getPortfolio() {
        return portfolioService.getPortfolio();
    }
}
