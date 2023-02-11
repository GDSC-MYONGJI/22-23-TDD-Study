package com.hou27.chap08;

public class UserPointCalculator {

  private SubscriptionDao subscriptionDao;
  private ProductDao productDao;

  public UserPointCalculator(
      SubscriptionDao subscriptionDao,
      ProductDao productDao
  ) {
    this.subscriptionDao = subscriptionDao;
    this.productDao = productDao;
  }

  public int calculatePoint(User u) {
    Subscription s = subscriptionDao.selectByUser(u);
    if(s == null) {
      throw new NoSubscriptionException();
    }

    Product p = productDao.selectById(s.getProductId());
    LocalDate now = LocalDate.now(); // 현재 날짜를 구한다.
    int point = 0;
    if(s.isFinished(now)) { // 현재 시간에 따라 결과가 달라진다.
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
