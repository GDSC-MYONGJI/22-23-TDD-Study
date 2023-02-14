package study.tdd.chap07.join;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
