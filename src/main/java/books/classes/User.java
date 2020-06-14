package books.classes;

public class User {
    private String name;
    private String secName;
    private String password;

    public User(){

    }
    public User(String name, String secName, String password) {
        this.name = name;
        this.secName = secName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", secName='" + secName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
