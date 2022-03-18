package com.liubin.foodie.admin.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取 Druid 的监控数据
 */
@RestController
@RequestMapping(value = "/druid")
public class DruidStatController {

    @GetMapping("/stat")
    public Object druidStat() {
        // 获取数据源的监控数据
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}