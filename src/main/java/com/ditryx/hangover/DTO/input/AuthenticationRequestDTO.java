package com.ditryx.hangover.DTO.input;

public class AuthenticationRequestDTO {
    private String login;
    private String password;

    public AuthenticationRequestDTO() {
    }

    public AuthenticationRequestDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
