package FileTasks;

/**
 * Created by vika on 27.08.2017.
 */
public class User {
    public int userId;
    public String userName;
    public String userPhone;

    public User(int id, String name, String phone) {
        this.userId = id;
        this.userName = name;
        this.userPhone = phone;
    }

    @Override
    public String toString() {
        return userId + ";" + userName + ";" + userPhone + ";";
    }
}
