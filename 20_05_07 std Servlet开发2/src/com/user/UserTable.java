package com.user;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User("jotailang", "承太郎", "111", 9999));
        list.add(new User("huahua", "卡q因", "222", 8888));
        list.add(new User("dio", "迪奥", "333", 7777));
    }

    public static User select(String username, String password){
        for (User user : list) {
            if (username.equals(user.username) && password.equals(user.password)) {
                return user;
            }
        }

        return null;
    }
}
