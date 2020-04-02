package com.stacksimplify.restservices.dtos;

public class UserMsDto {

    private Long userid;
    private String username;
    private String emailaddress;
    private String rolename;


    public  UserMsDto() {

    }

    public UserMsDto(Long userid, String username, String emailadress) {
        super();
        this.userid = userid;
        this.username = username;
        this.emailaddress = emailaddress;
        this.rolename = rolename;
    }

    //Getters and Setters
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailadress) {
        this.emailaddress = emailadress;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
