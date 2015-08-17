package com.profiler.rest.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sachindra on 28/07/2015.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String test(){
        return "index";
    }
}
