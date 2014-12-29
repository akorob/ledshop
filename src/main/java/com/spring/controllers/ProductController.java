package com.spring.controllers;

/**
 * Created by Andrey on 26.12.2014.
 */
import java.util.List;

import com.spring.model.ProductDto;
import com.spring.persistence.domain.Product;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public List<ProductDto> getGuests() {

        List<ProductDto> list = productService.findAll();

        return list;
    }
/*

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public void addContact(@ModelAttribute("contact")
                             Guest guest, BindingResult result) {
        String name =  guest.getName();
        System.out.println("Name:" + name);
        if (name != null)
            guestService.save(new Guest(name));

    }
*/

}
