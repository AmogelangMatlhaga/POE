/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matlhagaamogelangpoe;

/**
 *
 * @author Lethabo Molate
 */
public class Account {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String usernameErrorMessage;
    private String passwordErrorMessage;

    public Account(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usernameErrorMessage = "";
        this.passwordErrorMessage = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isUsernameValid() {
        boolean isValid = username.contains("_") && username.length() <= 5;
        if (!isValid) {
            usernameErrorMessage = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else {
            usernameErrorMessage = "";
        }
        return isValid;
    }

    public boolean isPasswordValid() {
        boolean isValid = password.length() >= 8 &&
                          password.matches(".*[A-Z].*") &&
                          password.matches(".*\\d.*") &&
                          password.matches(".*[!@#$%^&*()].*");
        if (!isValid) {
            passwordErrorMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            passwordErrorMessage = "";
        }
        return isValid;
    }

    public String getUsernameErrorMessage() {
        return usernameErrorMessage;
    }

    public String getPasswordErrorMessage() {

        return passwordErrorMessage;
    }   
}
