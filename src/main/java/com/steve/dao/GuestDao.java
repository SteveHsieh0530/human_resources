package com.steve.dao;

import com.steve.model.Guest;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestDao {
    Guest getGuestDaoByNameAndPass(Guest guest);
    void saveGuest(Guest guest);

    Guest getGuestById(Integer guest_id);
}
