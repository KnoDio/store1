package com.lin.service;

import com.lin.dao.ShopMapper;
import com.lin.pojo.Shop;

import java.util.List;

public class ShopServiceImpl  implements ShopService{
    private ShopMapper shopMapper;

    public void setShopMapper(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public int addShop(Shop shop) {
        return shopMapper.addShop(shop);
    }

    public int deleteShopById(int loadid) {
        return shopMapper.deleteShopById(loadid);
    }

    public List<Shop> queryByid(int id) {
        return  shopMapper.queryByid(id);
    }

    public int updateShop(Shop shop) {
        return 0;
    }

    public List<Shop> query(String string) {
        return shopMapper.querry(string);
    }

    public List<Shop> queryAllShop() {
        return shopMapper.queryAllShop();
    }

    public int creat_table() {
        int i = shopMapper.creat_table();
        return i;
    }
}
