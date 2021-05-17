package Model;

public class User {
    private int Id;
    private String Name;
    private int Age;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public User() {
    }

  /*  public User(int ID, String name, int age,String password) {
        Id = ID;
        Name = name;
        Age = age;
        Password = password;
    }*/

    public void setId(int ID) {
        Id = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
