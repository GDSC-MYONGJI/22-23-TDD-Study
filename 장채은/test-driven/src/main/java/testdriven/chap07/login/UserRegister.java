package testdriven.chap07.login;

public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker passwordChecker, UserRepository userRepository, SpyEmailNotifier spyEmailNotifier){
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = spyEmailNotifier;
    }
    public void register(String id, String pw, String email){
        if(passwordChecker.checkPasswordWeak(pw)){
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if(user != null){
            throw new DupIdException();
        }
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
