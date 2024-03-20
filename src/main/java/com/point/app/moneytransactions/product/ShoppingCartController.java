package com.point.app.moneytransactions.product;

import com.point.app.images.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/cart")
@AllArgsConstructor
public class ShoppingCartController {

    private ProductService productService;

    private ImageRepository imageRepository;

    private static final String CART = "redirect:/cart";

    private ShoppingCart shoppingCart;

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", shoppingCart.getItems());
        return "cart";
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId)  {
        shoppingCart.addItem(productService.getProductById(productId));
        return CART;
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            shoppingCart.removeItem(product);
        }
        return CART;
    }

    @PostMapping("/clear")
    public String clearCart() {
        shoppingCart.clearCart();
        return CART;
    }
}