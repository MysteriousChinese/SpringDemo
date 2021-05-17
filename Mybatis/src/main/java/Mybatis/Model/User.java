package Mybatis.Model;

import lombok.*;

@Getter
@Setter
public class User {
    private int UserId;
    private String UserName;
    private String UserPassword;
    private int UserAge;

    public User() {
    }

    public User(int userId, String userName, String userPassword, int userAge) {
        UserId = userId;
        UserName = userName;
        UserPassword = userPassword;
        UserAge = userAge;
    }
}
