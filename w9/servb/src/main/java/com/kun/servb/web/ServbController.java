package com.kun.servb.web;

import com.kun.servb.service.SbExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 * @date 2022/5/8
 */
@RequestMapping("/servb")
@RestController
public class ServbController {

    @Autowired
    private SbExchangeService sbExchangeService;

    @RequestMapping("/exchange")
    public String exchange() {
        sbExchangeService.exchange();
        return "success";
    }
}
