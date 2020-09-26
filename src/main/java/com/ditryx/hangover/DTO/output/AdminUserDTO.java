package com.ditryx.hangover.DTO.output;

import com.ditryx.hangover.entities.Status;
import com.ditryx.hangover.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDTO {

    private long id;
    private Timestamp createDate;
    private Timestamp updateDate;
    private Status status;
    private String login;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;

    public AdminUserDTO() {
    }

//    @JsonCreator
//    public AdminUserDTO(@JsonProperty("login") String login,
//                        @JsonProperty("firstName") String firstName,
//                        @JsonProperty("lastName") String lastName,
//                        @JsonProperty("middleName") String middleName,
//                        @JsonProperty("email") String email,
//                        @JsonProperty("phoneNumber") String phoneNumber) {
//        this.login = login;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleName = middleName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }

//    public User toEntity(){
//        User user = new User();
//        user.setId(id);
//        user.setLogin(login);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setMiddleName(middleName);
//        user.setEmail(email);
//        user.setPhoneNumber(phoneNumber);
//        return user;
//    }

    public static AdminUserDTO fromEntity(User user){
        AdminUserDTO userDTO = new AdminUserDTO();
        userDTO.setId(user.getId());
        userDTO.setCreateDate(user.getCreateDate());
        userDTO.setUpdateDate(user.getUpdateDate());
        userDTO.setStatus(user.getStatus());
        userDTO.setLogin(user.getLogin());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
