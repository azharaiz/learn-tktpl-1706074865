package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserUnitTest {
    User user;
    User userIncorrectEmail;
    User userEmptyName;

    @Before
    public void init() {
        user = new User("Azhar Rais", "azhar@gmail.com");
        userIncorrectEmail = new User("Azhar Rais", "azharaiz.gmail.com");
        userEmptyName = new User("", "azhar@gmail.com");
    }

    @Test
    public void user_correctGreeting() {
        assertEquals("Hello Azhar Rais", user.greetUser());
    }

    @Test
    public void user_incorrectNameGreeting() {
        assertEquals("Name not found", userEmptyName.greetUser());
    }

    @Test
    public void user_checkIncorrectEmail() {
        assertFalse(userIncorrectEmail.isEmailValid());
        assertEquals("Email Not Valid", userIncorrectEmail.checkEmail());
    }

    @Test
    public void user_checkCorrectEmail() {
        assertTrue(user.isEmailValid());
        assertEquals("Email Valid", user.checkEmail());
    }
}
