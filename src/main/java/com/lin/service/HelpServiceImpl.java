package com.lin.service;

import com.lin.dao.HelpMapper;
import com.lin.pojo.Help;

import java.util.List;

public class HelpServiceImpl implements HelpService {
    HelpMapper helpMapper;

    public HelpMapper getHelpMapper() {
        return helpMapper;
    }

    public void setHelpMapper(HelpMapper helpMapper) {
        this.helpMapper = helpMapper;
    }

    public int add(Help help) {
        return helpMapper.add(help);
    }

    public int delete(int uid) {
        return helpMapper.delete(uid);
    }

    public List<Help> query2(String string) {
        return helpMapper.query2(string);
    }

    public List<Help> query() {
        return helpMapper.query();
    }

    public  List<Help> query_link(int uid){
        return  helpMapper.query_link(uid);
    }

    public List<Help> queryById(int uid){
        return  helpMapper.queryById(uid);
    }
}
