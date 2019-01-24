package ${project_package}.domain;

public class Login {
    private String user;
    private String message;

    public Login() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
