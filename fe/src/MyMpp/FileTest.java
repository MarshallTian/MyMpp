package MyMpp;

import MyMpp.thrift.THdfsFileBlock;
import MyMpp.thrift.THdfsFileDesc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/25/15.
 */
public class FileTest {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void FilePrint(THdfsFileDesc fileDesc) {
        print(fileDesc.getFile_name());
        int i = 0;
        for (THdfsFileBlock fileBlock : fileDesc.getFile_blocks()) {
            print(i++ + " " + fileBlock.getOffset() + " " + fileBlock.getLength());
        }
    }

    public static void main(String[] args) {
        HdfsMDD mdd = new HdfsMDD("hdfs://test0:9000/OS_ORDER.txt");
        THdfsFileDesc fileDesc = new THdfsFileDesc();
        fileDesc.file_blocks = new ArrayList<THdfsFileBlock>();
        mdd.loadBlockMd(fileDesc);
        FilePrint(fileDesc);
    }
}
