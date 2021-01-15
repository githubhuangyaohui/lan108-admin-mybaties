package com.persistenthuang.lan108admin.service;

import com.persistenthuang.lan108admin.mapper.LanAuthorMapper;
import com.persistenthuang.lan108admin.pojo.LanAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanAuthorServiceImpl implements LanAuthorService {
    @Autowired
    LanAuthorMapper lanAuthorMapper;

    @Override
    public List<LanAuthor> ListAll() {
        return lanAuthorMapper.selectList(null);
    }

    @Override
    public LanAuthor getByAuthorID(int authorID) {
        LanAuthor author=new LanAuthor();
        author.setId(authorID);
        return lanAuthorMapper.selectOne(author);
    }

    @Override
    public int addAuthor(LanAuthor lanAuthor) {
        return lanAuthorMapper.insert(lanAuthor);
    }

    @Override
    public int updateAuthor(LanAuthor lanAuthor) {
        return lanAuthorMapper.update(lanAuthor);
    }

    @Override
    public boolean isExitByAuthorEmail(String email) {
        LanAuthor author= new LanAuthor();
        author.setAuthorEmail(email);
        LanAuthor lanAuthor = lanAuthorMapper.selectOne(author);
        return null != lanAuthor;
    }

    @Override
    public boolean isExitByAuthorPhone(String phone) {
        LanAuthor author= new LanAuthor();
        author.setAuthorPhone(phone);
        LanAuthor lanAuthor = lanAuthorMapper.selectOne(author);
        return null != lanAuthor;
    }
}
