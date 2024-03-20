package com.point.app.moneytransactions.order;

import com.point.app.moneytransactions.gateway.payment.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderService {

    private PaymentRepository paymentRepository;
    private OrderRepository orderRepository;

//    @Transactional
//    public OrderAck placingOrder(OrderRequest orderRequest) throws NotMatchingPriceException {
//        Order32 order = orderRequest.getOrder();
//        order = orderRepository.save(order);
//
//        Payment payment = orderRequest.getPayment();
//
//
//        orderRepository.save(order);
//        paymentRepository.save(payment);
//        return new OrderAck("Success", payment.getAmount(), payment);
//
//
//    }

}
