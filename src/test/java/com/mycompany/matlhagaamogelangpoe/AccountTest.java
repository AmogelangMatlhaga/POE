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
public class AccountTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        Account account = new Account("kyl_1", "password", "First", "Last");
        assertTrue(account.isUsernameValid());
        assertEquals("", account.getUsernameErrorMessage());
    }

    @Test
    public void testUsernameIncorrectlyFormatted_NoUnderscore() {
        Account account = new Account("kyl1", "password", "First", "Last");
        assertFalse(account.isUsernameValid());
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", account.getUsernameErrorMessage());
    }

    @Test
    public void testUsernameIncorrectlyFormatted_TooLong() {
        Account account = new Account("kyl_123", "password", "First", "Last");
        assertFalse(account.isUsernameValid());
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", account.getUsernameErrorMessage());
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        Account account = new Account("username", "Ch&&sec@ke99!", "First", "Last");
        assertTrue(account.isPasswordValid());
        assertEquals("", account.getPasswordErrorMessage());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoSpecialCharacter() {
        Account account = new Account("username", "Chasecake99", "First", "Last");
        assertFalse(account.isPasswordValid());
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", account.getPasswordErrorMessage());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoNumber() {
        Account account = new Account("username", "Ch&&sec@ke", "First", "Last");
        assertFalse(account.isPasswordValid());
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", account.getPasswordErrorMessage());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_NoUpperCaseLetter() {
        Account account = new Account("username", "ch&&sec@ke99", "First", "Last");
        assertFalse(account.isPasswordValid());
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", account.getPasswordErrorMessage());
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements_TooShort() {
        Account account = new Account("username", "Ch&&se9", "First", "Last");
        assertFalse(account.isPasswordValid());
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", account.getPasswordErrorMessage());
    }

    
}
