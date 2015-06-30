package MyMpp.service;

import MyMpp.FileTest;
import MyMpp.HdfsMDD;
import MyMpp.thrift.THdfsFileBlock;
import MyMpp.thrift.THdfsFileDesc;
import MyMpp.thrift.TRequestCtx;
//import com.sun.jdi.InternalException;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by root on 6/25/15.
 */
public class JniFrontend {
    private final static Logger LOG = LoggerFactory.getLogger(JniFrontend.class);

    private final static TBinaryProtocol.Factory protocolFactory_ =
            new TBinaryProtocol.Factory();

    public JniFrontend() {

    }

    public void createMddRequest(byte[] thriftQueryContext) throws IOException, TException {
        TRequestCtx requestCtx = new TRequestCtx();

        System.out.println("You Called Me");
        System.out.println("Begin to print file name! " + thriftQueryContext.length);

        /*TBinaryProtocol.Factory protocolFactory_ =
                new TBinaryProtocol.Factory();

        TDeserializer deserializer = new TDeserializer(protocolFactory_);

        try {
            deserializer.deserialize(requestCtx, thriftQueryContext);
        } catch (TException e) {
            throw new TException();
        }*/

        JniUtil.deserializeThrift(protocolFactory_, requestCtx, thriftQueryContext);

        System.out.println(requestCtx.file_name);

        HdfsMDD hdfsMDD = new HdfsMDD(requestCtx.getFile_name());

        System.out.println("Begin to print file name!");
        System.out.println(requestCtx.getFile_name());
        THdfsFileDesc fileDesc = new THdfsFileDesc();
        fileDesc.file_blocks = new ArrayList<THdfsFileBlock>();
        hdfsMDD.loadBlockMd(fileDesc);
        FileTest.FilePrint(fileDesc);
    }
}
