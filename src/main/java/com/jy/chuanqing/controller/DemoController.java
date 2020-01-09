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
        List<HistoryRecord> historyRecordList = historyRecordService.selectOneHistoryRecord();
        if (historyRecordList.size()==0){
            model.addAttribute("runningstatus", "空闲中");
        }else {
            model.addAttribute("runningstatus", "运行中");
        }
        return "record";
    }

    @RequestMapping("state.html")
    public String Transfer(Model model) {
        List<HistoryRecord> historyRecordList = historyRecordService.selectOneHistoryRecord();
        if (historyRecordList.size()==0){
            model.addAttribute("id","无");
            model.addAttribute("transferdirection", "无");
            model.addAttribute("requesttime", "无");
            model.addAttribute("sourcepath", "无");
            model.addAttribute("targetpath", "无");
            model.addAttribute("targetpath", "无");
            model.addAttribute("runningstatus", "空闲中");
        }else {
            model.addAttribute("id", historyRecordList.get(0).getId());
            model.addAttribute("transferdirection", historyRecordList.get(0).getTransferdirection());
            model.addAttribute("requesttime", historyRecordList.get(0).getRequesttime());
            model.addAttribute("sourcepath", historyRecordList.get(0).getSourcepath());
            model.addAttribute("targetpath", historyRecordList.get(0).getTargetpath());
            model.addAttribute("runningstatus", "运行中");
        }
        return "state";
    }

    @RequestMapping("index.html")
    public String index(Model model) {
        List<HistoryRecord> historyRecordList = historyRecordService.selectOneHistoryRecord();
        if (historyRecordList.size()==0){
            model.addAttribute("runningstatus", "空闲中");
        }else {
            model.addAttribute("runningstatus", "运行中");
        }
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