package kr.co.bootpay.demo.daoService;

import kr.co.bootpay.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
       users.add(new User(1, "Adam", new Date()));
       users.add(new User(1, "Eve", new Date()));
       users.add(new User(1, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if(user.getId()==null) {
            user.setId(users.size() + 1);
        }
        users.add(user);
        return user;
    }
}
