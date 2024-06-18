/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.matlhagaamogelangpoe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lethabo Molate
 */
public class LoginTest {

    @Test
    public void testLoginSuccessful() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertTrue(login.loginUser("user_1", "P@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongPassword() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("user_1", "WrongP@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongUsername() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("wrong_user", "P@ssw0rd!"));
    }

    @Test
    public void testLoginFailed_WrongUsernameAndPassword() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("wrong_user", "WrongP@ssw0rd!"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertTrue(login.loginUser("user_1", "P@ssw0rd!"));
        assertEquals("Welcome John Doe, it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        Account account = new Account("user_1", "P@ssw0rd!", "John", "Doe");
        Login login = new Login(account);
        assertFalse(login.loginUser("user_1", "WrongP@ssw0rd!"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
  
}
