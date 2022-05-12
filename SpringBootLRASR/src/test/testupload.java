import com.jxz.service.HDFSupload.HDFSUpload;

import java.io.File;

public class testupload {
    public static void main(String[] args) throws Exception {
        HDFSUpload hdfsUpload = new HDFSUpload("Urban", 16);
        hdfsUpload.init();
        hdfsUpload.upload();
    }
}
