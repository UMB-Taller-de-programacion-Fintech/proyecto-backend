package com.example.demo.model.dto;

public class UserDTO {

    private Number _id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    // Constructor
    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public void setId (Number _id) {
        this._id = _id;
    }


    // Getters y Setters
    public String getFirstName() {
        return firstName;
    }

    public Number getId() {
        return _id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}