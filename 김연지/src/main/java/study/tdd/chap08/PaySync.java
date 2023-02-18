package study.tdd.chap08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PaySync {
    /*
    // 의존 대상을 직접 생성
    private PayInfoDao payInfoDao = new PayInfoDao();

    public void sync() throws IOException {
        Path path = Paths.get("D:\\data\\pay\\cp0001.csv");
        List<PayInfo> payInfos = Files.lines(path)
                .map(line -> {
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(
                            data[0], data[1], Integer.parseInt(data[2])
                    );
                    return payInfo;
                })
                .collect(Collectors.toList());
        payInfos.forEach(pi -> payInfoDao.insert(pi));
    }
    */

    /*
    // 세터를 이용해서 값을 교체 가능하게 함으로써 테스트가 쉬워짐
    private String filePath = "D:\\data\\pay\\cp0001.csv";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void sync() throws IOException {
        Path path = Paths.get(filePath);
        ...
    }
    */

    /*
    // 하드 코딩된 경로를 파라미터로 전달받아 테스트 가능하게 변경
    public void sync(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        ...
    }
    */
}
