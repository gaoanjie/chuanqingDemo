package com.jy.chuanqing.controller;

import com.jy.chuanqing.domain.HistoryRecord;
import com.jy.chuanqing.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertHistoryRecord(HistoryRecord historyRecord) {
        historyRecordService.insertHistoryRecord(historyRecord);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/where", method = RequestMethod.GET)
    public List<HistoryRecord> selectWhereHistoryRecord(HistoryRecord historyRecord) {
        List<HistoryRecord> historyRecords = historyRecordService.selectWhereHistoryRecord(historyRecord);
        return historyRecords;
    }
}