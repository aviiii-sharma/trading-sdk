package com.bajajbroking.trading.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Trade {

    private String tradeId;
    private String orderId;
    private String symbol;
    private int quantity;
    private double executedPrice;
    private LocalDateTime executedAt;

    public Trade() {
        this.tradeId = UUID.randomUUID().toString();
        this.executedAt = LocalDateTime.now();
    }

    public Trade(String orderId, String symbol, int quantity, double executedPrice) {
        this();
        this.orderId = orderId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.executedPrice = executedPrice;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getExecutedPrice() {
        return executedPrice;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }
}
