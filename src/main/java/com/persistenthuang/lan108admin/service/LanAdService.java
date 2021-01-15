package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.pojo.LanAd;

import java.util.List;

public interface LanAdService {
    List<LanAd> getLanAdList();
    int insertAd(LanAd ad);
    int updateAd(LanAd ad);
    int deleteAd(int id);
}
