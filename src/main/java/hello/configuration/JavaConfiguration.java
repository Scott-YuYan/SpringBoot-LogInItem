package hello.configuration;

import hello.entity.testUser;
import hello.service.OrderService;
import hello.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

    @Bean
    public testUser user(){
        return new testUser(1,"lisi");
    }


    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public OrderService orderService(UserService userService){
        return new OrderService(userService);
    }
}
