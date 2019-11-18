package hello.service;

import hello.entity.testUser;

public class UserService {

    public testUser getUserById(Integer id,String name) {
        return new testUser(id,name);
    }
}
