package com.steve.service;

import com.steve.model.Guest;

public interface GuestService {
    Guest Login(String name, String pass);

    boolean register(String name, String pass);

    Guest getGuestById(Integer guest_id);


}
