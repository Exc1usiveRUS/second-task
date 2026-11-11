package org.example.order.service;

import org.example.order.factory.commission.DefaultCommissionHandlerFactory;
import org.example.order.factory.commission.interfaces.CommissionHandlerFactory;
import org.example.order.factory.discount.DefaultDiscountHandlerFactory;
import org.example.order.factory.discount.interfaces.DiscountHandlerFactory;
import org.example.order.model.Order;
import org.example.order.service.print.ConsolePrinter;
import org.example.order.service.print.interfaces.Printer;
import org.example.order.validation.OrderValidator;

import java.util.ArrayList;
import java.util.List;

/**
 Контекст: Тебе достался в наследство код от предыдущего разработчика — сервис обработки заказов интернет-магазина OrderService.
 Он работает, тесты (если бы они были) прошли бы, заказчик доволен... пока не попросил добавить новый тип клиента или способ оплаты.
 Тут выясняется, что каждое такое "простое" изменение требует лезть в один и тот же метод на 80 строк, где всё завязано друг на друга,
 и есть риск что-то сломать в соседней логике.
 Твоя задача: не переписать сервис с нуля, а отрефакторить — сохранив то же поведение (те же скидки, та же комиссия, тот же чек)
 Опирайся на SOLID и паттерны проектирования
 Lombok использовать нельзя, все писать руками.
 */

public class InMemoryOrderService implements OrderService {

    private final List<Order> orders = new ArrayList<>();

    private final OrderValidator validator;
    private final DiscountHandlerFactory discountHandlerFactory;
    private final CommissionHandlerFactory commissionHandlerFactory;
    private final Printer printer;

    //конструктор по умолчанию - совместим со старым способом использования
    public InMemoryOrderService() {
        this(
                new OrderValidator(),
                new DefaultDiscountHandlerFactory(),
                new DefaultCommissionHandlerFactory(),
                new ConsolePrinter()
        );
    }

    public InMemoryOrderService(OrderValidator validator,
                        DiscountHandlerFactory discountHandlerFactory,
                        CommissionHandlerFactory commissionHandlerFactory,
                        Printer printer) {
        this.validator = validator;
        this.discountHandlerFactory = discountHandlerFactory;
        this.commissionHandlerFactory = commissionHandlerFactory;
        this.printer = printer;
    }

    @Override
    public double processOrder(Order order) {

        validator.validate(order);

        //скидка
        double discount = discountHandlerFactory
                .create(order.getCustomerType())
                .calculateDiscount(order);

        //комиссия
        double commission = commissionHandlerFactory
                .create(order.getPaymentType())
                .calculateCommission(order);

        //итоговая сумма
        double finalAmount = order.getAmount() - discount + commission;

        //чек
        printer.print(order, discount, commission, finalAmount);

        //сохранение заказа
        orders.add(order);

        return finalAmount;
    }
}

