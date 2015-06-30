#include "hdfs-scan-node.h"
#include "runtime/descriptors.h"
#include "runtime/disk-io-mgr.h"

#include <boost/algorothm/string.hpp>
#include <boost/foreach.hpp>
#include <boost/filesystem.hpp>

#include <hdfs.h>

namespace MyMpp {

HdfsScanNode::~HdfsScanNode() {
}

HdfsScanner* HdfsScanNode::CreateAndPrepareScanner(HdfsPartitionDescriptor* partition) {
    HdfsScanner* scanner = NULL;
    switch (partition->file_format()) {
        case HdfsFileFormat::TEXT:
            scanner = new HdfsTextScanner(this); break;
            
        default:
            return NULL;
    }
    
    return scanner;
}

void HdfsScanNode::ScannerThread() {
    while (!done_) {
        //unique_lock<mutex> l(lock_);
        
        DiskIoMgr::ScanRange* scan_range;
        
        HdfsPartitionDescriptor* partition;
        
        HdfsScanner* scanner = CreateAndPrepareScanner(partition);
        
        scanner->ProcessSplit();
    }
}

}



