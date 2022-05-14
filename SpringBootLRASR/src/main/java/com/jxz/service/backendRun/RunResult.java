package com.jxz.service.backendRun;

public class RunResult {
    double[] stopC;
    double AUC;
    double time;

    public RunResult(double[] stopC, double AUC, double time) {
        this.stopC = stopC;
        this.AUC = AUC;
        this.time = time;
    }

    public double[] getStopC() {
        return stopC;
    }

    public void setStopC(double[] stopC) {
        this.stopC = stopC;
    }

    public double getAUC() {
        return AUC;
    }

    public void setAUC(double AUC) {
        this.AUC = AUC;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
