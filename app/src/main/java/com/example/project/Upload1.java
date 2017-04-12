package com.example.project;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Musee on 3/28/2017.
 */

public class Upload1 {

    public String name;
    public String url;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)

    public Upload1() {
    }

    public Upload1(String name, String url) {
        this.name = name;
        this.url= url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

}
