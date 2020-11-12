package sample;

public class AccountProfile {
    private String name;
    private String email;
    private String username;
    private String password;

    public AccountProfile(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return name+":"+email+":"+username;
    }
}
