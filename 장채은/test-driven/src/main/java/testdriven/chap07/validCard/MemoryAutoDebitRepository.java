package testdriven.chap07.validCard;

import java.util.HashMap;
import java.util.Map;

/**
 * 외부 상황 흉내: 특정 사용자에 대한 자동 이체 정보가 이미 등록되어 있거나, 있지 않은 상황을 흉내냄.
 */
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
