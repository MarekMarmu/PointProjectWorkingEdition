package com.point.app.moneytransactions.gateway.stripenew;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {


    private String secretKey = "sk_test_51OkqlmLeLdCh8uOv2dPfER6BmBldTYlAJ3amiZyF0BcHE3sOio24RW1BD4ApBNV7ZWcMHROKL5rxiGHRu4qt1pkj00JNeb5uxa";

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    public Charge charge(ChargeRequest chargeRequest)
            throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount",  chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}