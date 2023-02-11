package com.hou27.chap08;

import java.time.LocalDate;

public class UserPointCalculator {

  private SubscriptionDao subscriptionDao;
  private ProductDao productDao;
  private Times times;

  public UserPointCalculator(
      SubscriptionDao subscriptionDao,
      ProductDao productDao,
      Times times
  ) {
    this.subscriptionDao = subscriptionDao;
    this.productDao = productDao;
    this.times = times;
  }

  public int calculatePoint(User u) {
    Subscription s = subscriptionDao.selectByUser(u);
    if(s == null) {
      throw new NoSubscriptionException();
    }

    Product p = productDao.selectById(s.getProductId());
//    LocalDate now = LocalDate.now(); // 현재 날짜를 구한다.
    LocalDate now = times.today(); // 현재 날짜를 구한다.
    PointRule rule = new PointRule();
    int point = rule.calculate(s, p, now);
//    int point = 0;
//    if(s.isFinished(now)) { // 현재 시간에 따라 결과가 달라진다.
//      point += p.getDefaultPoint();
//    } else {
//      point += p.getDefaultPoint() + 10;
//    }
//
//    if(s.getGrade() == GOLD) {
//      point += 100;
//    }

    return point;
  }
}

class PointRule {
  public int calculate(Subscription s, Product p, LocalDate now) {
    int point = 0;
    if(s.isFinished(now)) {
      point += p.getDefaultPoint();
    } else {
      point += p.getDefaultPoint() + 10;
    }

    if(s.getGrade() == GOLD) {
      point += 100;
    }

    return point;
  }
}