package models;

import com.github.javafaker.Faker;

public class User {
    private String username;
    private String email;
    private String password;

    public User() {
        Faker faker = new Faker();
        this.username = faker.name().username();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
