/* 
 * File:   disk-io-mgr-internal.h
 * Author: root
 *
 * Created on June 24, 2015, 9:27 AM
 */

#ifndef DISK_IO_MGR_INTERNAL_H
#define	DISK_IO_MGR_INTERNAL_H

#include "disk-io-mgr.h"
#include <queue>
#include <boost/thread/locks.hpp>
#include <unistd.h>
#include "common/hdfs.h"
//#include <gutil/strings/substitute.h>

namespace MyMpp {

struct DiskIoMgr::DiskQueue {
    int disk_id;
    
    boost::mutex lock;
    
    boost::condition_variable work_available;
    
    
    
    
};

class DiskIoMgr::RequestContext {
public:
    enum State {
        Active,
        
        Cancelled,
        
        Inactive,
        
        
    };
    
private:
    friend class DiskIoMgr;
    
    class PerDiskState;
    
    DiskIoMgr* parent_;
    
    hdfsFS hdfs_connection_;
    
    int initial_queue_capacity_;
    
    boost::mutex lock_;
    
    int num_disks_with_ranges_;
    
    InternalQueue<ScanRange> cached_ranges_;
    
    InternalQueue<ScanRange> ready_to_start_ranges_;
    boost::condition_variable ready_to_start_ranges_cv_;
    
    InternalQueue<ScanRange> blocked_ranges_;
    
    boost::condition_variable disks_complete_cond_var_;
    
    class PerDiskState {
    public:
    private:
        
        bool done_;
        
        bool is_on_queue_;
        
        int num_remaining_ranges_;
        
        InternalQueue<ScanRange> unstarted_scan_ranges_;
        
        InternalQueue<RequestRange> in_flight_ranges_;
        
        ScanRange* next_scan_range_to_start_;
        
        AtomicInt<int> num_threads_in_op_;
        
        //InternalQueue<WriteRange> unstarted_write_ranges_;
        
        
    };
    
    std::vector<PerDiskState> disk_states_;
};
}

#endif	/* DISK_IO_MGR_INTERNAL_H */

