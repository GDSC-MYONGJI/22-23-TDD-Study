package com.hou27.chap08;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class PaySync {
  // 의존 객체를 직접 생성하고 있다.
  private PayInfoDao payInfoDao = new PayInfoDao();

  public void sync() {
    // 하드 코딩된 경로를 사용하고 있다.
    Path path = Path.of("tmp/paydata/payinfo.csv");
    List<PayInfo> payInfos = Files.lines(path)
        .map(line -> {
          String[] data = line.split(",");
          return new PayInfo(data[0], Integer.parseInt(data[1]));
        }).collect(Collectors.toList());

    payInfos.forEach(pi -> payInfoDao.insert(pi));
  }
}
