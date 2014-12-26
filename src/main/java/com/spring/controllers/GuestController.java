package com.spring.controllers;

/**
 * Created by Andrey on 26.12.2014.
 */
import java.util.Date;
import java.util.List;

import com.spring.persistence.entity.Guest;
import com.spring.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

//    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value="/guests", method = RequestMethod.GET)
    public @ResponseBody  List<Guest> getGuests() {

        List<Guest> list = guestService.findAllGuests();
        for(Guest g: list){
            System.out.println(g);
        }

        return list;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public void addContact(@ModelAttribute("contact")
                             Guest guest, BindingResult result) {
        String name =  guest.getName();
        System.out.println("Name:" + name);
        if (name != null)
            guestService.save(new Guest(name));

    }

}
