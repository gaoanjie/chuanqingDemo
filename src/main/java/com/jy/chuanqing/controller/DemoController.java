package com.jy.chuanqing.controller;

import com.jy.chuanqing.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DemoController {
    @Autowired
    HistoryRecordService historyRecordService;

    @RequestMapping("lsjl.html")
    public String HistoryRecord(Model model) {
        model.addAttribute("historyrecordlist", historyRecordService.selectAllHistoryRecord());
        return "lsjl";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}