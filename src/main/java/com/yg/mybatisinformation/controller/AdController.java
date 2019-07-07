package com.yg.mybatisinformation.controller;

import com.yg.mybatisinformation.pojo.Administrator;
import com.yg.mybatisinformation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //responseBody 和Controller注解的组合
@RequestMapping("/AdAll")
public class AdController {
    @Autowired
    private AdministratorService administratorService;

    @RequestMapping(value = "/QueryAdAll",method = RequestMethod.GET)
    private Map<String,Object> AdAll(){
        Map<String,Object> AdMap=new HashMap<String,Object>();
        List<Administrator> list=administratorService.queryAllAd();
        AdMap.put("AdAll",list);
        return AdMap;
    }
}
