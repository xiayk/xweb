package com.xiayk.xwebshorturl.controller;

import com.xiayk.xwebshorturl.model.Url;
import com.xiayk.xwebshorturl.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LinkController
 * @Author XiaYk
 * @Date 2019-11-02 03:20
 * @Version 1.0
 */
@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/{code}")
    public String toUrl(@PathVariable("code") String code){
        return "redirect:"+linkService.shortToLong(code);
    }

    @ResponseBody
    @RequestMapping("/toShortUrl")
    public String getShortUrl(@RequestBody Url url){
        return linkService.longToShort(url.getUrl());
    }

    @ResponseBody
    @GetMapping("/toLongUrl")
    public String getLongUrl(@RequestBody Url url){
        return linkService.shortToLong(url.getUrl());
    }
}
