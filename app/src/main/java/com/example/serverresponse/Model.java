package com.example.serverresponse;



public class Model {

    public String id, email, first_name, last_name, avatar;


    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Model(String id, String email, String first_name, String last_name, String avatar) {




        this.setId(id);
        this.setEmail(email);
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setAvatar(avatar);


    }


}
