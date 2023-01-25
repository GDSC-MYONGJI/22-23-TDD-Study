package com.hou27.chap05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleTest {
  public LifecycleTest() {
    System.out.println("LifecycleTest 생성자");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("beforeEach");
  }

  @Test
  void test1() {
    System.out.println("test1");
  }

  @Test
  void test2() {
    System.out.println("test2");
  }

  @AfterEach
  void afterEach() {
    System.out.println("afterEach");
  }

}
