package com.bajajbroking.trading.service;

import com.bajajbroking.trading.exception.ApiException;
import com.bajajbroking.trading.model.Order;
import com.bajajbroking.trading.model.Trade;
import com.bajajbroking.trading.model.enums.OrderStatus;
import com.bajajbroking.trading.model.enums.OrderStyle;
import com.bajajbroking.trading.model.enums.OrderType;
import com.bajajbroking.trading.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final TradeService tradeService;
    private final PortfolioService portfolioService;

    public OrderService(OrderRepository orderRepository,
                        TradeService tradeService,
                        PortfolioService portfolioService) {
        this.orderRepository = orderRepository;
        this.tradeService = tradeService;
        this.portfolioService = portfolioService;
    }

    public Order placeOrder(Order order) {

        validateOrder(order);

        order.setStatus(OrderStatus.PLACED);
        orderRepository.save(order);

        // Simple execution logic
        if (order.getOrderStyle() == OrderStyle.MARKET) {
            executeOrder(order, order.getPrice() != null ? order.getPrice() : 0);
        } else {
            // LIMIT order - simulate immediate execution
            executeOrder(order, order.getPrice());
        }

        return order;
    }

    private void executeOrder(Order order, double executionPrice) {

        order.setStatus(OrderStatus.EXECUTED);
        orderRepository.save(order);

        Trade trade = new Trade(
                order.getOrderId(),
                order.getSymbol(),
                order.getQuantity(),
                executionPrice
        );

        tradeService.saveTrade(trade);

        if (order.getOrderType() == OrderType.BUY) {
            portfolioService.updateHolding(
                    order.getSymbol(),
                    order.getQuantity(),
                    executionPrice
            );
        }
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    private void validateOrder(Order order) {

    if (order.getQuantity() <= 0) {
        throw new ApiException("Quantity must be greater than zero");
    }

    if (order.getOrderStyle() == OrderStyle.LIMIT && order.getPrice() == null) {
        throw new ApiException("Price is required for LIMIT orders");
    }

    if (order.getOrderType() == null || order.getOrderStyle() == null) {
        throw new ApiException("Order type and style are mandatory");
    }
}

}
