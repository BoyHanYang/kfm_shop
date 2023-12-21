package com.kfm.shop.goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.kfm.shop.comment.util.Result;
import com.kfm.shop.goods.model.Goods;
import com.kfm.shop.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yangbohan
 * @Date 2023/12/19 21:32
 */
@RestController
@RequestMapping("/goods")
@Api(tags = "商品管理")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping
    @ApiOperation(value = "获取所有商品信息", notes = "获取所有商品信息")
    public Result getGoods(@ApiParam(name = "goods",value = "商品信息") Goods goods) {
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(goods.getName())){
            queryWrapper.like("name",goods.getName());
        }
        if (!ObjectUtils.isEmpty(goods.getPrice())){
            queryWrapper.eq("status",goods.getStatus());
        }
        PageHelper.startPage(goods.getPage(),goods.getSize());
        return Result.ok(goodsService.list(queryWrapper));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取商品信息", notes = "根据id获取商品信息")
    public Result getGoodsById(@ApiParam(name = "id", value = "商品id", required = true) @PathVariable Integer id) {
        return Result.ok(goodsService.getById(id));
    }


    @PostMapping("/edit")
    @ApiOperation(value = "根据id修改商品信息", notes = "根据id修改商品信息")
    public Result updateGoodsById(@ApiParam(name = "goods", value = "商品信息", required = true) Goods goods) {
        return Result.ok(goodsService.updateById(goods));
    }


    @PutMapping("/add")
    @ApiOperation(value = "新增商品信息", notes = "新增商品信息")
    public Result addGoods(@ApiParam(name = "goods", value = "商品信息", required = true) Goods goods) {
        return Result.ok(goodsService.save(goods));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除商品信息", notes = "根据id删除商品信息")
    public Result deleteGoodsById(@ApiParam(name = "id", value = "商品id", required = true) @PathVariable Integer id) {
        return Result.ok(goodsService.removeById(id));
    }
}
