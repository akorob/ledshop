package com.spring.service;

/**
 * Created by Andrey on 26.12.2014.
 */
import java.util.List;

import com.spring.persistence.dao.GuestDao;
import com.spring.persistence.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestDao guestDao;

    @Transactional
    public void save(Guest guest) {
        guestDao.persist(guest);
    }


    public List<Guest> findAllGuests() {
        return guestDao.getAllGuests();
    }
}