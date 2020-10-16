package TestSuite.Tests;

import TestSuite.Model.User;
import TestSuite.Model.UserBuilder;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UserTypeTests {

    @Test
    @Description("Check User types - enum declared within User class")
    public void VerifyUserTypeEnum() {
        User u2 = new UserBuilder().username("u2").Usertype(User.UserType.Standard).build();
        User u3 = new UserBuilder().username("u3").Usertype(User.UserType.Super).build();

        if (u2.usertype == User.UserType.Standard) {
            System.out.println("u2 is a standard user");
        }
    }
}

