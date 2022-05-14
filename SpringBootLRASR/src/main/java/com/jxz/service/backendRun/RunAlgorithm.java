package com.jxz.service.backendRun;

import com.jxz.service.HDFSupload.HDFSUpload;
import com.jxz.service.LRASRalgorithm.LRASRMain;
import scala.Tuple3;

public class RunAlgorithm {
    String method;
    String parallelism;
    String jobname;

    public RunAlgorithm(String method, String parallelism, String jobname) {
        this.method = method;
        this.parallelism = parallelism;
        this.jobname = jobname;
    }

    public RunResult run() throws Exception {
        HDFSUpload hdfsUpload = new HDFSUpload(jobname, Integer.parseInt(parallelism));
        HDFSUpload.init();
        hdfsUpload.upload();
        Tuple3<double[], Double, Double> mainRes = LRASRMain.main(new String[]{jobname,"hdfs://master:9000/jxz/"});
        return new RunResult(mainRes._1(),mainRes._2(),mainRes._3());
    }
}
