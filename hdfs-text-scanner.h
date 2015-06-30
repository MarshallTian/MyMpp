/* 
 * File:   hdfs-text-scanner.h
 * Author: root
 *
 * Created on June 24, 2015, 7:48 PM
 */

#ifndef HDFS_TEXT_SCANNER_H
#define	HDFS_TEXT_SCANNER_H

#include "hdfs-scanner.h"

namespace MyMpp {

class HdfsTextScanner : public HdfsScanner {
public:
    HdfsTextScanner(HdfsScanNode* scan_node);
    virtual ~HdfsTextScanner();
    
    virtual Status ProcessSplit();
};

}

#endif	/* HDFS_TEXT_SCANNER_H */

