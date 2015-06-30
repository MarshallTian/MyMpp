package MyMpp;

import MyMpp.thrift.THdfsFileBlock;
import MyMpp.thrift.THdfsFileDesc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/25/15.
 */
public class FileTest {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void FilePrint(THdfsFileDesc fileDesc) throws IOException {
        PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("/home/code/MyMpp/1.txt")));

        p.println("You Called Me!");

        //p.close();
        p.println(fileDesc.getFile_name());
        int i = 0;
        for (THdfsFileBlock fileBlock : fileDesc.getFile_blocks()) {
            p.println(i++ + " " + fileBlock.getOffset() + " " + fileBlock.getLength());
        }

        p.close();
    }

    public static void main(String[] args) throws IOException {

        HdfsMDD mdd = new HdfsMDD("hdfs://test0:9000/OS_ORDER.txt");
        THdfsFileDesc fileDesc = new THdfsFileDesc();
        fileDesc.file_blocks = new ArrayList<THdfsFileBlock>();
        mdd.loadBlockMd(fileDesc);
        FilePrint(fileDesc);
    }
}
