package com.point.app.moneytransactions.gateway;


import com.point.app.moneytransactions.gateway.payment.PaymentRepository;
import com.point.app.moneytransactions.product.Product;
import com.point.app.moneytransactions.product.ProductRepository;
import com.point.app.moneytransactions.product.ShoppingCart;
import com.point.app.thymeleaf.CurrentUserUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import java.util.List;

@Controller
@AllArgsConstructor
public class PaypalController {

    private PaypalService service;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    private final PaymentRepository paymentRepository;
    private final ShoppingCart shoppingCart;
    private final CurrentUserUtil currentUserUtil;
    private final ProductRepository productRepository;

    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") Order order) {

        try {
            Payment payment = service.createPayment(order.price(), order.currency(), order.method(),
                    order.intent(), order.description(), "http://localhost:8080/" + CANCEL_URL,
                    "http://localhost:8080/" + SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {

            Payment payment = service.executePayment(paymentId, payerId);
            System.err.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                paymentRepository.save(new com.point.app.moneytransactions.gateway.payment.Payment(shoppingCart.getItems(), currentUserUtil.getAuthenticatedUser()));
                shoppingCart.getItems().forEach(product ->  product.setPieces(product.getPieces()-1));
                 List<Product> collect = shoppingCart.getItems().stream().filter(product ->
                        product.getPieces() >= 0
                ).toList();
                productRepository.saveAll(collect);

                shoppingCart.clearCart();

                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/home";
    }
}