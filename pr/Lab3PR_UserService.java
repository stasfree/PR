package ua.pr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab3PR_UserService {
    public Map users = new HashMap<>();
    private final AtomicInteger count = new AtomicInteger(0);

    public Lab3PR_User findById(String id) {
        return (Lab3PR_User) users.get(id);
    }

    public Lab3PR_User add(String name, String email) {
        int currentId = count.incrementAndGet();
        Lab3PR_User user = new Lab3PR_User(currentId, name, email);
        users.put(String.valueOf(currentId), user);
        return user;
    }

    public Lab3PR_User update(String id, String name, String email) {

        Lab3PR_User user = (Lab3PR_User) users.get(id);
        if (name != null) {
            user.setName(name);
        }

        if (email != null) {
            user.setEmail(email);
        }
        users.put(id, user);

        return user;

    }

    public void delete(String id) {
        users.remove(id);
    }

    public List findAll() {
        return new ArrayList<>(users.values());
    }

    public Lab3PR_UserService() {
    }
}

