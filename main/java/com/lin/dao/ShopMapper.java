package com.lin.dao;

import com.lin.pojo.Shop;

import java.util.List;

public interface ShopMapper {
    //增加一个Book
    int addShop(Shop shop);

    //根据id删除一个Book
    int deleteShopById(int loadid);

    List<Shop> queryByid(int id);

    //更新Book
    int updateShop(Shop shop);

    //根据id查询,返回一个Book
    List<Shop>  querry(String string);

    //查询全部Book,返回list集合
    List<Shop> queryAllShop();

    int creat_table();

}
