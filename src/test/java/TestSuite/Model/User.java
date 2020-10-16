package TestSuite.Model;

public class User {
    public String username;

    public String password;

    public UserType usertype;

    public enum UserType
    {
        Standard,
        Admin,
        Super
    };

    public User(UserBuilder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
        this.usertype = builder.usertype;
    }
}
