package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.LanAdMapper;
import com.persistenthuang.lan108admin.pojo.LanAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanAdServiceImpl implements LanAdService {

    @Autowired
    LanAdMapper lanAdMapper;

    @Override
    public List<LanAd> getLanAdList() {
        return lanAdMapper.select();
    }

    @Override
    public int insertAd(LanAd ad) {
        return lanAdMapper
                .insert(ad);
    }

    @Override
    public int updateAd(LanAd ad) {
        return lanAdMapper.update(ad);
    }

    @Override
    public int deleteAd(int id) {
        LanAd lanAd = new LanAd();
        lanAd.setId(id);
        return lanAdMapper.delete(lanAd);
    }
}
