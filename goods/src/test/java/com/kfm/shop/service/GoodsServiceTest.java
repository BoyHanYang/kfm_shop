package com.kfm.shop.service;

import com.kfm.shop.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void test() {
        assertNotNull(goodsService);
    }

    /**
     * 测试find方法
     */
    @Test
    public void find() {
        List<Goods> list = goodsService.list();  // 调用goodsService的list方法获取商品列表
        System.out.println(list);  // 打印商品列表
        assertEquals(2, list.size());  // 断言商品列表的大小为1
    }

    @Test
    public void saveOrUpdate() {
        Goods goods = new Goods();
        goods.setName("测试商品1");
        goods.setPrice(10000L);
        goods.setNum(100);
        goods.setStatus(1);
        goodsService.save(goods);  // 调用goodsService的save方法保存商品
        List<Goods> list = goodsService.list();  // 调用goodsService的list方法获取商品列表
        System.out.println(list);  // 打印商品列表
    }

}