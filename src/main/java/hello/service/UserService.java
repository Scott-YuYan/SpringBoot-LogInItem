package hello.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserService implements UserDetailsService {
    private static Map<String, String> UserDataBase = new HashMap<>();
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Inject
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        save("user","password");
    }

    public void save(String username, String password) {
        UserDataBase.put(username, bCryptPasswordEncoder.encode(password));
    }

    public String getPassword(String username) {
        return UserDataBase.get(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = UserDataBase.get(username);
        if (!UserDataBase.containsKey(username)) {
            throw new UsernameNotFoundException(username + "用戶不存在");
        } else {
            return new User(username, password, Collections.emptyList());
        }

    }
}
