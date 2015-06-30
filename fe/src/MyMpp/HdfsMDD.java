package MyMpp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.s3.Block;
import org.apache.hadoop.hdfs.DistributedFileSystem;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import MyMpp.thrift.*;

import com.google.common.collect.Lists;

/**
 * Created by root on 6/25/15.
 */
public class HdfsMDD {
    //private final List<HdfsPartition> partitions_;

    private long totalHdfsBytes_;

    protected String hdfsBaseDir_;

    private List<String> hostIndex_ = new ArrayList<String>();

    private final static Logger LOG = LoggerFactory.getLogger(HdfsMDD.class);

    private static final Configuration CONF = new Configuration();

    private static final DistributedFileSystem DFS;

    private String location_;

    static {
        try {

            FileSystem fs = FileSystem.get(URI.create("hdfs://test0:9000/"), CONF);
            if (!(fs instanceof DistributedFileSystem)) {
                String error = "Cannot connect to HDFS. " +
                        CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY +
                        "(" + CONF.get(CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY) + ")" +
                        " might be set incorrectly";
                throw new RuntimeException(error);
            }
            DFS = (DistributedFileSystem) fs;
        } catch (IOException e) {
            throw new RuntimeException("couldn't retrieve FileSystem:\n" + e.getMessage(), e);
        }
    }

    public HdfsMDD(String location) {
        this.location_ = location;
    }

    public List<String> getHostIndex() { return hostIndex_; }

    public String getHdfsBaseDir() { return hdfsBaseDir_; }

    public void loadBlockMd(THdfsFileDesc fileDesc) throws RuntimeException {
        fileDesc.file_name = location_;
        List<BlockLocation> blockLocations = new ArrayList();
        Path p = new Path(location_);
        BlockLocation[] locations = null;
        try {
            FileStatus fileStatus = DFS.getFileStatus(p);

            locations = DFS.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());

            blockLocations.addAll(Arrays.asList(locations));

            for (BlockLocation block : locations) {
                String[] blockHostPorts;
                try {
                    blockHostPorts = block.getNames();

                } catch (IOException e) {
                    // this shouldn't happen, getNames() doesn't throw anything
                    String errorMsg = "BlockLocation.getNames() failed:\n" + e.getMessage();
                    LOG.error(errorMsg);
                    throw new IllegalStateException(errorMsg);
                }
                List<Integer> replicaHostIdxs = new ArrayList<Integer>(blockHostPorts.length);
                for (int i = 0; i < blockHostPorts.length; ++i) {
                    replicaHostIdxs.add(hostIndex_.indexOf(blockHostPorts[i]));
                    THdfsFileBlock fileBlock = new THdfsFileBlock(block.getOffset(), block.getLength(), replicaHostIdxs);
                    fileDesc.file_blocks.add(fileBlock);
                }
            }

        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }



}
