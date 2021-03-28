import domain.users.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class UsersTest {
    private static User user1;
    private static User user2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void createUsers() {
        user1 = new User("Nataliya", "svk", 56646, "56452ghh54");
        user2 = new User("Alexander", "kim", 46843, "54746jm458");
    }
    @DataPoint
    public static String userName = "Nataliya";

    @DataPoints
    public static String[] usersNames() {
        return new String[]{ user1.getName(), user2.getName()};
    }

    @Theory
    public void testUsersName (String name) throws Exception {
        Assert.assertEquals("Nataliya", user1.getName());
//        System.out.println(String.format("Testing with %s and %s", name));
//        assumeNotNull(name);
//        assumeThat(name, notNullValue());
//        String actual= User.createUsers(name);
//        System.out.println(String.format("Actual: %s \n", actual));
//        assertThat(actual, is(allOf(containsString(name))); //тема в проработке. еще допишу код
    }
}