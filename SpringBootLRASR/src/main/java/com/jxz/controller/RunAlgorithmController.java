package com.jxz.controller;
//
import com.jxz.service.LRASRalgorithm.LRASRMain;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/run")
@CrossOrigin
public class RunAlgorithmController {
    @GetMapping("/")
    public String result(@RequestParam("method")String method,@RequestParam("parallelism")String parallelism,@RequestParam("jobname")String jobname){
        System.out.println(method);
        System.out.println(parallelism);
        System.out.println(jobname);
        return "run success";
    }
}
