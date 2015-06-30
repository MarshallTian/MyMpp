/* 
 * File:   hdfs-scan-node.h
 * Author: root
 *
 * Created on June 23, 2015, 5:13 PM
 */

#ifndef HDFS_SCAN_NODE_H
#define	HDFS_SCAN_NODE_H
#include <hdfs>
#include "scan-node.h"
#include "hdfs-scanner.h"

namespace MyMpp {

struct HdfsFileDesc {
    std::string filename;

    int64_t file_length;

    std::vector<DiskIoMgr::ScanRange*> splits;

    HdfsFileDesc(const std::string& filename)
    : filename(filename), file_length(0) {
    }
};

struct ScanRangeMetadata {
    int64_t partition_id;
    
    ScanRangeMetadata(int64_t partition_id) : partition_id(partition_id) { }
};



class HdfsScanNode : public ScanNode {
public:
    HdfsScanNode(const DescriptorTbl& descs);

    ~HdfsScanNode();
    
    HdfsScanner* CreateAndPrepareScanner(HdfsPartitionDescriptor* partition_desc,
        ScannerContext* context);
    
    void ScannerThread();
    
    
};
}

#endif	/* HDFS_SCAN_NODE_H */

