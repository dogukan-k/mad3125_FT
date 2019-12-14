package dku.presentation.group.com.register;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String name ;
    private String eMail;
    private String phone;
    private String imageResource;

    public static List<User> userList= new ArrayList<User>();







    public User(){

    }

    public User(String name , String eMail , String phone){

        this.name = name;
        this.eMail = eMail;
        this.phone = phone;




    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }




}
