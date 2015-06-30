package MyMpp.service;

import MyMpp.FileTest;
import MyMpp.HdfsMDD;
import MyMpp.thrift.THdfsFileBlock;
import MyMpp.thrift.THdfsFileDesc;
import MyMpp.thrift.TRequestCtx;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public void createMddRequest(byte[] thriftQueryContext) {
        TRequestCtx requestCtx = new TRequestCtx();

        JniUtil.deserializeThrift(protocolFactory_, requestCtx, thriftQueryContext);

        HdfsMDD hdfsMDD = new HdfsMDD(requestCtx.getFile_name());
        THdfsFileDesc fileDesc = new THdfsFileDesc();
        fileDesc.file_blocks = new ArrayList<THdfsFileBlock>();
        hdfsMDD.loadBlockMd(fileDesc);
        FileTest.FilePrint(fileDesc);
    }
}
