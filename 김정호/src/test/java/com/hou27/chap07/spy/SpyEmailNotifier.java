package com.hou27.chap07.spy;

public class SpyEmailNotifier implements EmailNotifier {
  private boolean called;
  private String email;

  public boolean isCalled() {
    return called;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public void sendRegisterEmail(String email) {
    called = true;
    this.email = email;
  }
}