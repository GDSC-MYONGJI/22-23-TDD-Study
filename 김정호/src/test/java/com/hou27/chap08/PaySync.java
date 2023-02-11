package com.hou27.chap08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class PaySync {
  private PayInfoDao payInfoDao;
  private String filePath = "tmp/paydata/payinfo.csv";

  // 생성자를 통해 의존성을 주입받는다.
  public PaySync(PayInfoDao payInfoDao) {
    this.payInfoDao = payInfoDao;
  }

  // 경로를 설정 가능하게 메서드 생성
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public void sync() throws IOException {
    Path path = Path.of(filePath);
    List<PayInfo> payInfos = Files.lines(path)
        .map(line -> {
          String[] data = line.split(",");
          return new PayInfo(data[0], Integer.parseInt(data[1]));
        }).collect(Collectors.toList());

    payInfos.forEach(pi -> payInfoDao.insert(pi));
  }
}
