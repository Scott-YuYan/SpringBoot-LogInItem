package hello;

import hello.entity.Result;
import hello.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class AuthController {

    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;

    public AuthController(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }


    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public Object getAuth() {
        return new Result("ok","用户没有登录",false);
    }

    @PostMapping(value = "/auth/login")
    @ResponseBody
    public Result loginVerify(@RequestBody Map<String, Object> nameAndPassword) {
        String username = (String) nameAndPassword.get("username");
        String password = (String) nameAndPassword.get("password");
        //获取用户名所对应的真正的密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //将两个密码进行比较
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        //比较的结果如果成功，则会为该对象填充好对应的权限，否则丢出异常
        try {
            authenticationManager.authenticate(token);
            //鉴权成功
            SecurityContextHolder.getContext().setAuthentication(token);
            User user = new User(1,username,"头像 url", Instant.now(),Instant.now());
            return new Result("ok","登录成功",true,user);
        }catch (BadCredentialsException e){
            //说明用户名密码不对
            return new Result("fail","用户不存在",false);

        }
    }
}
