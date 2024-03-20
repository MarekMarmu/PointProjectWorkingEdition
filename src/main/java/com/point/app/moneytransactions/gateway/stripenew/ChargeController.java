package com.point.app.moneytransactions.gateway.stripenew;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/charge")
public class ChargeController {

    private final StripeService paymentsService;

    @PostMapping
    public String charge(ChargeRequest chargeRequest, Model model) {
        try {
            chargeRequest.setDescription("Example charge");
            chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
            Charge charge = paymentsService.charge(chargeRequest);
            model.addAttribute("id", charge.getId());
            model.addAttribute("status", charge.getStatus());
            model.addAttribute("chargeId", charge.getId());
            model.addAttribute("balance_transaction", charge.getBalanceTransaction());
            System.out.println("vse gut");
            return "Charge";
        } catch (StripeException ex) {
            System.out.println("problem");
            model.addAttribute("error", ex.getMessage());
            return "Charge";
        }
    }

}
