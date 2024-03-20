package com.point.app.moneytransactions.product.company;

import com.point.app.exceptions.ObjectDoesNotExistsException;
import com.point.app.moneytransactions.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;

    private final ProductRepository productRepository;

    @GetMapping(path = "/{id}")
    public String getCompanyById(@PathVariable Long id, Model model) throws ObjectDoesNotExistsException {
        model.addAttribute("listOfProducts", productRepository.findProductsByCompanyId(id));
        model.addAttribute("company", companyRepository.findCompanyById(id).orElseThrow(ObjectDoesNotExistsException::new));
        return "Company";
    }
}
