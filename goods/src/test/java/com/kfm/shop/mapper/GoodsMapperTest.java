package com.kfm.shop.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kfm.shop.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsMapperTest {
    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    public void test(){
        System.out.println(goodsMapper);
        Assert.notNull(goodsMapper,"goodsMapper is null");
    }

    @Test
    public void selectAll(){
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","苹果");

        List<Goods> goods = goodsMapper.selectList(null);
        System.out.println(goods);
        assertEquals(1,goods.size());
    }

    @Test
    public void insert(){
        Goods goods = new Goods();
        goods.setName("测试商品");
        goods.setPrice(100L);
        goods.setNum(100);
        goods.setStatus(1);
        int i = goodsMapper.insert(goods);
        System.out.println(i);
        assertEquals(1,i);
    }
}