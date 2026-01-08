package com.bajajbroking.trading.model;

import com.bajajbroking.trading.model.enums.OrderStatus;
import com.bajajbroking.trading.model.enums.OrderStyle;
import com.bajajbroking.trading.model.enums.OrderType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {

    private String orderId;
    private String symbol;
    private OrderType orderType;
    private OrderStyle orderStyle;
    private int quantity;
    private Double price;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.NEW;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderStyle getOrderStyle() {
        return orderStyle;
    }

    public void setOrderStyle(OrderStyle orderStyle) {
        this.orderStyle = orderStyle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
