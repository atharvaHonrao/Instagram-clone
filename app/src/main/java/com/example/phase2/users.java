package com.example.phase2;

import org.bson.types.ObjectId;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class users extends RealmObject {

//    @PrimaryKey
//    private ObjectId _id = new ObjectId();
    private String username;
    private String fullname;
    private String profilephoto;
    private String bio;

    public users(String username, String fullname, String profilephoto, String bio) {
        this.username = username;
        this.fullname = fullname;
        this.profilephoto = profilephoto;
        this.bio = bio;
    }

    public users() {
    } // RealmObject subclasses must provide an empty constructor

    public String getusername() {
        return username;
    }

    public void setUsername(String usernamename) {
        this.username = username;
    }

    public String getbio() {
        return bio;
    }

    public void setbio(int age) {
        this.bio = bio;
    }

    public String getProfilephoto() {
        return profilephoto;
    }

    public void setProfilephoto(String profilephoto) {
        this.profilephoto = profilephoto;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public ObjectId get_id() {
//        return _id;
//    }


}
