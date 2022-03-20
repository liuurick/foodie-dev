package com.liubin.generate.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.liubin.generate.config.ErwinProperties;
import com.liubin.generate.service.IndexService;
import com.liubin.generate.vo.CodeGeneratorRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

    private IndexService indexService;
    private ErwinProperties erwinProperties;

    @Autowired
    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    @Autowired
    public void setErwinProperties(ErwinProperties erwinProperties) {
        this.erwinProperties = erwinProperties;
    }


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("version", erwinProperties.getApp().getVersion());
        return "index";
    }

    @PostMapping("/code-generator")
    @ResponseBody
    public ResponseTemplate<Void> codeGenerator(@RequestBody @Validated CodeGeneratorRequestVO requestVo) {
        return indexService.codeGenerator(requestVo);
    }

}
