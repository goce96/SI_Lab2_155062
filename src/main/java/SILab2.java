import java.util.ArrayList;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public  boolean function (User user, List<String> allUsers) {  //1
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //2
        if (user==null) {   //3
            throw new RuntimeException("The user is not instantiated");  //4
        }
        if (user.getUsername()==null || user.getPassword()==null)    //5
            throw new RuntimeException("The user is missing some mandatory information");  //6
        String password = user.getPassword();   //7
        String passwordLower = password.toLowerCase();  //8
        if (passwordLower.contains(user.getUsername().toLowerCase())) {  //9
            return false;    //10
        }
        else if (passwordLower.length()<8)   //11
            return false;      //12
        else {      //13
            boolean digit = false, upper = false, special = false;  //14

            for (int i=0;i<password.length();i++) {    //15
                if (Character.isDigit(password.charAt(i)))    //16
                    digit = true;       //17
                if (Character.isUpperCase(password.charAt(i)))  //18
                    upper = true;    //19
                if (specialCharacters.contains(String.valueOf(password.charAt(i))))  //20
                    special = true;    //21
            }    //22
            if (!digit || !upper || !special)   //23
                return false;   //24
        }
        return true;    //25
    } //26


}