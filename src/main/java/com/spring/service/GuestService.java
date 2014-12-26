package com.spring.service;

/**
 * Created by Andrey on 26.12.2014.
 */
import com.spring.persistence.entity.Guest;

import java.util.List;

public interface GuestService {

    public abstract void save(Guest guest);

    public abstract List<Guest> findAllGuests();

}