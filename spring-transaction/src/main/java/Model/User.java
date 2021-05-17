package Model;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private  int user_age;

    public User(int user_id, String user_name, String user_password, int user_age) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_age = user_age;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }
}
