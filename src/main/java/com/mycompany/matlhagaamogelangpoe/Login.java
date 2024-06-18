/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matlhagaamogelangpoe;

/**
 *
 * @author Lethabo Molate
 */
public class Login {
    private final Account account;

    public Login(Account account) {
        this.account = account;
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(account.getUsername()) && enteredPassword.equals(account.getPassword());
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + account.getFirstName() + " " + account.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }   
}
