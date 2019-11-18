package hello.service;

public class OrderService {
    private UserService userService;


    public OrderService(UserService userService) {
        this.userService = userService;
    }


    public void placeOrder(Integer userId,String name) {
        System.out.println(userService.getUserById(userId,name));
    }
}
