package com.example.tdd_project.chapter7;

import java.util.HashMap;

public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository{
    private Map<String, AutoDebitInfo> infos = new HashMap<>();

    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
