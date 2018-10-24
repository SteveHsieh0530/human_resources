package com.steve.service.impl;

import com.steve.dao.GuestDao;
import com.steve.model.Guest;
import com.steve.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;

    @Override
    public Guest Login(String name, String pass) {

        Guest guest = new Guest();
        guest.setG_name(name);
        guest.setG_pass(pass);
        return guestDao.getGuestDaoByNameAndPass(guest);
    }

    @Override
    public boolean register(String name, String pass) {
        Guest guest = new Guest();
        guest.setG_name(name);
        guest.setG_pass(pass);

        guestDao.saveGuest(guest);

        return false;
    }

    @Override
    public Guest getGuestById(Integer guest_id) {

        return guestDao.getGuestById(guest_id);
    }
}
