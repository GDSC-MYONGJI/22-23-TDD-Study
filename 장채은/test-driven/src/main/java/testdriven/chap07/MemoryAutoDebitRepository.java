package testdriven.chap07;

import java.util.HashMap;
import java.util.Map;

// AutoDebitInfoRepository 의 대역
public class MemoryAutoDebitRepository implements AutoDebitInfoRepository{

    // 영속성을 제공하지는 않지만, 테스트에서 사용할 수 있을 만큼의 기능을 제공
    private Map<String, AutoDebitInfo> infos = new HashMap<>();
    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserIdx(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
