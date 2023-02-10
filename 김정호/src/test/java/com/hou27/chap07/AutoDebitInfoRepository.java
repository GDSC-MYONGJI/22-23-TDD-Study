package com.hou27.chap07;

public interface AutoDebitInfoRepository {
  AutoDebitInfo findOne(String userId);
  void save(AutoDebitInfo info);
}
