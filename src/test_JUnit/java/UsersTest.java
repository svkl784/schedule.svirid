import domain.users.User;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
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

    @DataPoints
    public static String[] usersNames() {
        return new String[]{user1.getName(), user2.getName()};
    }

    @Theory
    public void testUsersNames(String name) throws Exception {
        System.out.println(String.format("Testing with name %s and login %s", name));
        assumeNotNull(name);
        assumeThat(name, notNullValue());
    }

    @DataPoints
    public static String[] usersLogin() {
        return new String[]{user1.getLogin(), user2.getLogin()};
    }

    @Theory
    public void testUsersLogin(String login) throws Exception {
        System.out.println(String.format("Testing with login %s ", login));
        assumeNotNull(login);
        assumeThat(login, notNullValue());
    }

    @DataPoints
    public static int[] usersPassword() {
        return new int[]{(int) user1.getPassword(), (int) user2.getPassword()};
    }

    @Theory
    public void testUsersPassword(int password) throws Exception {
        System.out.println(String.format("Testing with password %d ", password));
        assumeNotNull(password);
        assumeThat(password, notNullValue());
    }
}