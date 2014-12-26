package com.spring.persistence.dao;

/**
 * Created by Andrey on 26.12.2014.
 */
import com.spring.persistence.entity.Guest;

import java.util.List;

public interface GuestDao {

    public abstract void persist(Guest guest);

    public abstract List<Guest> getAllGuests();

}