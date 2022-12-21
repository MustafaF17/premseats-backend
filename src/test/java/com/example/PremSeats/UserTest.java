package com.example.PremSeats;
import static org.junit.jupiter.api.Assertions.*;

import com.example.PremSeats.model.User;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void TestGetSetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1, user.getId());
    }

    @Test
    void TestSetPassword() {
        User user = new User();
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void TestSetRole() {
        User user = new User();
        user.setRoles("Guest");
        assertEquals("Guest", user.getRoles());
    }

    @Test
    void TestSetBalance() {
        User user = new User();
        user.setBalance(50.00);
        assertEquals(50.00, user.getBalance());
    }









}
