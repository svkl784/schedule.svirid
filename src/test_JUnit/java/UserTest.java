import domain.users.User;
import exception.PasswordException;
import org.junit.*;
import org.junit.experimental.theories.Theories;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private static User user1;
    private static User user2;


    @BeforeClass
    public static void createUsers() {
        user1 = new User("Nataliya", "svk", 56646, "56452ghh54");
        user2 = new User("Alexander", "kim", 46843, "54746jm458");
    }

    @Test
    public void getAllUsers() {
        List<User> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        assertEquals(expected, actual);
    }

    @Test
    public void notNullUser() {
        Assert.assertNotNull(user1);
        Assert.assertNotNull(user2);
    }

    @Test
    public void notNullName() {
        Assert.assertNotNull(user1.getName());
        Assert.assertNotNull(user2.getName());
    }


    @Test
    public void equalsName() {
        Assert.assertEquals("Nataliya", user1.getName());
        Assert.assertEquals("Alexander", user2.getName());
    }


    @Test
    public void passwordShouldThrowPasswordException() throws PasswordException {
        User user4 = new User("Nataliya", "svk", 5655646, "56452ghh54");
        User user5 = new User("Alexander", "kim", 52, "54746jm458");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }
}



