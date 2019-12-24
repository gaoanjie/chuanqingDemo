package com.jy.chuanqing.controller;

import com.jy.chuanqing.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @Autowired
    HistoryRecordService historyRecordService;

    @RequestMapping("record.html")
    /**
     * 把list放入model中，在html中通过thymeleaf的th标签直接引用
     **/
    public String HistoryRecord(Model model) {
        model.addAttribute("historyrecordlist", historyRecordService.selectAllHistoryRecord());
        return "record";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}