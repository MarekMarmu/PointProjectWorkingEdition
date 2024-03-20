package com.point.app;

import com.point.app.images.Image;
import com.point.app.images.ImageRepository;
import com.point.app.moneytransactions.gateway.Order;
import com.point.app.moneytransactions.product.Product;
import com.point.app.moneytransactions.product.ShoppingCart;

import com.point.app.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;


@Controller
@Slf4j
@AllArgsConstructor
public class TemplateController {

    private ShoppingCart shoppingCart;
    private ImageRepository imageRepository;
    private RestTemplate restTemplate;
    @GetMapping("/login")
    public String customLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "STProfile_LogIn";
    }
    @GetMapping("/seacher")
    public String penysa() {
        return "search";
    }



    @GetMapping("/STProfileRegistered")
    public String userInfo() {
        System.out.println("dfsafdasdfdsfasdf");

       log.info( SecurityContextHolder.getContext().getAuthentication().getName());
        return "STProfileRegistered";
    }

    @GetMapping("/boba")
    public String customLogi() {
        return "boba";
    }


    @GetMapping("/registration")
    public String customRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "STProfile";
    }

//    @GetMapping("/")
//    public String homePage() {
//        return "Index";
//    }

    @GetMapping("/userProfile")
    public String userProfile() {
        return "STProfileRegistered";
    }

    @GetMapping("/upload")
    public String uploadImage() {
        return "testing/ImageSaver";
    }

    @GetMapping("/STProfileR")
    public String sTProfileR() {
        return "STProfileR";
    }

    @GetMapping("/profiler")
    public String STProfileR() {
        return "STProfileR";
    }

    @GetMapping("/paypal")
    public String STHome(Model model) throws IOException {
    if (!shoppingCart.getItems().isEmpty()) {
        String url = "https://api.paypal.com/v1/catalogs/currencies";
        ResponseEntity<Currency[]> response = restTemplate.getForEntity(url, Currency[].class);
        Currency[] currencies = response.getBody();
        System.out.println(Arrays.stream(currencies).toList());


//        List<Currency> currencies = Currency.getAvailableCurrencies().stream()
//                .sorted(Comparator.comparing(Currency::getCurrencyCode))
//                .toList();

        double finalPrice = shoppingCart.getItems()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

        model.addAttribute("order", new Order(finalPrice,null,null,null,null));
        model.addAttribute("cartItems", shoppingCart.getItems());
        model.addAttribute("finalPrice", finalPrice);
        model.addAttribute("currencies", currencies);
        return "payment";
    }
        return "redirect:/cart";
    }

    @GetMapping("/UploadImage")
    public String UploadImage(Model model) {
        model.addAttribute("image", new Image());
        return "UploadImage";
    }


    @GetMapping("/STIndex")
    public String STindex() {
        return "STIndex";
    }
}