/* 
 * File:   hdfs-scanner.h
 * Author: root
 *
 * Created on June 23, 2015, 5:08 PM
 */

#ifndef HDFS_SCANNER_H
#define	HDFS_SCANNER_H

#include <vector>
#include <memory>
#include <stdint.h>
#include <boost/regex.hpp>
#include <boost/scoped_ptr.hpp>

#include "common/status.h"

namespace MyMpp {

struct FieldLocation {
    char* start;
    
    int len;
};

class HdfsScanner {
public:
    const static int FILE_BLOCK_SIZE = 4096;
    
    HdfsScanner(HdfsScanNode* scan_node);
    
    virtual ~HdfsScanner();
    
    virtual Status ProcessSplit() = 0;
    
protected:
    
    HdfsScanNode* scan_node_;
    
    
    
};

}

#endif	/* HDFS_SCANNER_H */

