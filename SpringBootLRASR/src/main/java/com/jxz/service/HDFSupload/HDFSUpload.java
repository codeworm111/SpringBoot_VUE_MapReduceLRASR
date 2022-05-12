package com.jxz.service.HDFSupload;

import org.apache.hadoop.fs.FileSystem;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.*;
import java.net.URI;

public class HDFSUpload {
    String jobname;
    int blocknum;
    static FileSystem fs=null;
    static Configuration conf=null;
    public HDFSUpload(String jobname, int blocknum){
        this.jobname=jobname;
        this.blocknum=blocknum;
    }

    public static void init() throws Exception{

        //1.创建文件系统
        conf =new Configuration();
        //2.设置副本数
        conf.set("dfs.replication","1");
    }

    //上传文件
    public void upload() throws Exception, IOException {

        //3.设置block大小为1M ,上传时候使用,仅对当前方法有效
        long size1=new File("./src/main/java/com/jxz/HSI/"+jobname+"_gt.bin").length();
        conf.set("dfs.blocksize",String.valueOf(size1));
        //4.创建文件系统对象
        fs = FileSystem.get(new URI("hdfs://master:9000/"),conf);
        //前面为上传文件的路径，后面是HDFS中的路径和文件的新名称
        fs.copyFromLocalFile(new Path("./src/main/java/com/jxz/HSI/"+jobname+"_gt.bin"),
                new Path("hdfs://master:9000/jxz/"+jobname+"_gt.bin"));
        fs.close();
        System.out.println("gt上传成功...");

        long size2=new File("./src/main/java/com/jxz/HSI/"+jobname+"_hdr.hdr").length();
        conf.set("dfs.blocksize",String.valueOf(size2));
        fs = FileSystem.get(new URI("hdfs://master:9000/"),conf);
        fs.copyFromLocalFile(new Path("./src/main/java/com/jxz/HSI/"+jobname+"_hdr.hdr"),
                new Path("hdfs://master:9000/jxz/"+jobname+"_hdr.hdr"));
        fs.close();
        System.out.println("hdr上传成功...");


        long size3=new File("./src/main/java/com/jxz/HSI/"+jobname+"_img.bin").length()/blocknum;
        conf.set("dfs.blocksize",String.valueOf(size3));
        fs = FileSystem.get(new URI("hdfs://master:9000/"),conf);
        fs.copyFromLocalFile(new Path("./src/main/java/com/jxz/HSI/"+jobname+"_img.bin"),
                new Path("hdfs://master:9000/jxz/"+jobname+"_img.bin"));
        fs.close();
        System.out.println("img上传成功...");
    }


}
