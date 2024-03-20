
package com.point.app.moneytransactions.gateway.stripenew;

import com.point.app.moneytransactions.product.Product;
import com.point.app.moneytransactions.product.ShoppingCart;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CheckoutController {

    private String stripePublicKey = "pk_test_51OkqlmLeLdCh8uOvZfQqMNCfBDjBXKXnGEO2tiXan3m2PZeuYbAs9Ip0x1I8jreBGw7VvMRVFKe3VeV4bJvKexwt000NzVQOFV";
    @NonNull
    private ShoppingCart shoppingCart;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", (int) shoppingCart.getItems().stream().mapToDouble(Product::getPrice).sum()*100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "stripePayment";
    }
}
