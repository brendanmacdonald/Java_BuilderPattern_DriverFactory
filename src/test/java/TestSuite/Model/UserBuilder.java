package TestSuite.Model;

public class UserBuilder {
    public String username;
    public String password;
    public User.UserType usertype;

    public UserBuilder username(String username)
    {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password)
    {
        this.password = password;
        return this;
    }

    public UserBuilder Usertype(User.UserType usertype)
    {
        this.usertype = usertype;
        return this;
    }

    public User build()
    {
        return new User(this);
    }
}
