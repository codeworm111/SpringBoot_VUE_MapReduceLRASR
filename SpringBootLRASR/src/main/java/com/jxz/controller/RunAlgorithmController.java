package com.jxz.controller;
//
import com.jxz.service.LRASRalgorithm.LRASRMain;
import com.jxz.service.backendRun.RunAlgorithm;
import com.jxz.service.backendRun.RunResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/run")
@CrossOrigin
public class RunAlgorithmController {
    @GetMapping("/")
    public RunResult result(@RequestParam("method")String method,@RequestParam("parallelism")String parallelism,@RequestParam("jobname")String jobname) throws Exception {
        RunResult runResult = new RunAlgorithm(method, parallelism, jobname).run();
        return runResult;
    }
}
