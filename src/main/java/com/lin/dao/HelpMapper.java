package com.lin.dao;

import com.lin.pojo.Help;

import java.util.List;

public interface HelpMapper {
    public int add(Help help);

    public int delete(int uid);

    public List<Help> query();

     public   List<Help>  query2(String string);

    public  List<Help> query_link(int uid);

    public List<Help> queryById(int uid);
}
