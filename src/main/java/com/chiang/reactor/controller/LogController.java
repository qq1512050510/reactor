package com.chiang.reactor.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

    @RequestMapping(path = "/logTest",method = RequestMethod.GET)
    public void logTest(){
        log.info("logTest");
    }

}
