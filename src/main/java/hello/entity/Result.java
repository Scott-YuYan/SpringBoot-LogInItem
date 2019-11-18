package hello.entity;

public class Result {
    private String status;
    private String msg;
    private boolean isLogIn;
    private User user;



    public Result(String status, String msg, boolean isLogIn) {
        this(status, msg, isLogIn, null);
    }

    public Result(String status, String msg, boolean isLogIn, User user) {
        this.status = status;
        this.msg = msg;
        this.isLogIn = isLogIn;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public User getUser() {
        return user;
    }
}
