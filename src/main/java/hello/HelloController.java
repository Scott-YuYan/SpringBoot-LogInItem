package hello;

import hello.service.OrderService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.jws.WebMethod;

@RestController
public class HelloController {

    private OrderService orderService;

    @Inject
    public HelloController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping("/")
    public String index() {
        orderService.placeOrder(1,"zhangsan");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        return username;
    }

}
