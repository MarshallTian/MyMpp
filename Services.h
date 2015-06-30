/* 
 * File:   Services.h
 * Author: root
 *
 * Created on June 23, 2015, 4:32 PM
 */

#ifndef SERVICES_H
#define	SERVICES_H

namespace MyMpp {
    
class HdfsFileSplit {
public:
    HdfsFileSplit() : path(), offset(0), length(0), partition_id(0), file_length(0) {}
    std::string path;
    int64_t offset;
    int64_t length;
    int64_t partition_id;
    int64_t file_length;
    
    void set_path(const std::string & val) {
        path = val;
    }
    
    void set_offset(const int64_t val) {
        offset = val;
    }

    void set_length(const int64_t val) {
      length = val;
    }

    void set_partition_id(const int64_t val) {
      partition_id = val;
    }

    void set_file_length(const int64_t val) {
      file_length = val;
    }
};

class ScanRange {
public:
    ScanRange() {}
    virtual ~ScanRange() {}
    
    HdfsFileSplit hdfs_file_split;
    
    void set_hdfs_file_split(const HdfsFileSplit & val) {
        hdfs_file_split = val;
    }
};

class ScanRangeParams {
public :
    ScanRangeParams() : volume_id(-1), is_cached(false) {} 
    int32_t volume_id;
    bool is_cached;
    
    virtual ~ScanRangeParams() throw() {}
    
    ScanRange scan_range;
    
    void set_scan_range(const ScanRange& val) {
        scan_range = val;
    }
};

}
#endif	/* SERVICES_H */

