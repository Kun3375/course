package com.kun.serva.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 * @date 2022/5/8
 */
@RequestMapping("/serva")
@RestController
public class ServaController {

    @RequestMapping
    public String test() {
        return "test";
    }
}
