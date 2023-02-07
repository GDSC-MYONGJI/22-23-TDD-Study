package com.hou27.chap07.spy;

public class UserRegister {
  private WeakPasswordChecker passwordChecker;
  private UserRepository userRepository;
  private EmailNotifier emailNotifier;

  public UserRegister(WeakPasswordChecker passwordChecker,
      EmailNotifier emailNotifier,
      UserRepository userRepository) {
    this.passwordChecker = passwordChecker;
    this.emailNotifier = emailNotifier;
    this.userRepository = userRepository;
  }

  public void register(String id, String pw, String email) {
    if(passwordChecker.checkPasswordWeak(pw)) {
      throw new WeakPasswordException();
    }

    User user = new User(id, pw, email);
    userRepository.save(user);

    emailNotifier.sendRegisterEmail(email);
  }

}
