/* 
 * File:   disk-io-mgr.h
 * Author: root
 *
 * Created on June 23, 2015, 7:06 PM
 */

#ifndef DISK_IO_MGR_H
#define	DISK_IO_MGR_H

#include <list>
#include <vector>

#include "common/status.h"

namespace MyMpp {

class DiskIoMgr {
public:
    class RequestContext;
    class ScanRange;
    // Buffer struct that is used by the caller and IoMgr to pass read buffers

    class BufferDescriptor {
    public:

        ScanRange* scan_range() {
            return scan_range_;
        }
    private:
        friend class DiskIoMgr;
        BufferDescriptor(DiskIoMgr* io_mgr);

        DiskIoMgr* io_mgr_;

        ScanRange* scan_range_;

        char* buffer;

        int64_t buffer_len_;

        int64_t len_;

        bool eosr_;

        int64_t scan_range_offset_;
    };

    struct RequestType {

        enum type {
            READ,
            WRITE,
        };
    };

    // Represents a contiguous sequence of bytes in a single file.

    class RequestRange : public InternalQueue<RequestRange>::Node {
    public:

        const char* file() const {
            return file_.c_str();
        }

        int64_t offset() const {
            return offset_;
        }

        int64_t len() const {
            return len_;
        }

        int disk_id() const {
            return disk_id_;
        }

        RequestType::type request_type() const {
            return request_type_;
        }

    protected:
        // Path to file being read or written
        std::string file_;

        // Offset within file_ being read or written
        int64_t offset_;

        // Length of data read or written
        int64_t len_;

        // Id of disk containing file_;
        int disk_id_;

        // The type of IO request
        RequestType::type request_type_;

    };

    class ScanRange : public RequestRange {
    public:
        ScanRange(int initial_capacity = -1);

        virtual ~ScanRange();

    private:
        friend class DiskIoMgr;

        void InitInternal(DiskIoMgr* io_mgr, RequestContext* reader);

        bool EnqueueBuffer(BufferDescriptor* buffer);

        void CleanupQueuedBuffers();

        Status Open();

        void Close();
    };
    
    class WriteRange : public RequestRange {
    public:
        WriteRange(const std::string& file, int64_t file_offset, int disk_id);
    private:
        friend class DiskIoMgr;
        
        const uint8_t* data_;
        
        
    };

};

}

#endif	/* DISK_IO_MGR_H */

