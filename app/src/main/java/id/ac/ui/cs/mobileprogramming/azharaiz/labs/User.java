package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

public class User {
    private String name = "";
    private String email = "";
    public User(String inputName, String inputEmail) {
        name = inputName;
        email = inputEmail;
    }

    public String greetUser() {
        if (name.replaceAll("\\s","").equals("")) {
            return "Name not found";
        }
        return "Hello " + name;
    }

    public boolean isEmailValid() {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String checkEmail() {
        if (this.isEmailValid()) {
            return "Email Valid";
        }
        return "Email Not Valid";
    }
}
