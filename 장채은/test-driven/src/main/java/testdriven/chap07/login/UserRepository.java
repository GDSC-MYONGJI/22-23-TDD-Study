package testdriven.chap07.login;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
