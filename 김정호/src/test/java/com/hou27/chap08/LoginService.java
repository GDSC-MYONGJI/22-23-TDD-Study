package com.hou27.chap08;

public class LoginService {

  private String authKey = "some_key";
  private CustomerRepository customerRepository;

  public LoginService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public LoginResult login(String id, String password) {
    int resp = 0;
    boolean authorized = AuthUtil.authorize(authKey); // 정적 메서드를 사용
    if (authorized) {
      resp = AuthUtil.authenticate(id, password); // 정적 메서드를 사용
    } else {
      resp = -1;
    }

    if (resp == -1) {
      return LoginResult.badAuthKey();
    } else if (resp == 1) {
      return LoginResult.success();
    } else {
      return LoginResult.fail();
    }
  }

}
