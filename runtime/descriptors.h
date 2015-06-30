/* 
 * File:   descriptors.h
 * Author: root
 *
 * Created on June 24, 2015, 5:09 PM
 */

#ifndef DESCRIPTORS_H
#define	DESCRIPTORS_H

namespace MyMpp {

struct HdfsFileFormat {
    enum type {
        TEXT = 0,
        LZO_TEXT = 1,
    };
};

class HdfsPartitionDescriptor {
public:
    
    HdfsPartitionDescriptor(int block_size, std::string location, int64_t id) :
    block_size_(block_size), location_(location), id_(id) {}
    
    int block_size() const { return block_size_; }
    const std::string& location() const { return location_; }
    int64_t id() const { return id_; }
    HdfsFileFormat::type file_format() { return file_format_; }
    
private:
    int block_size_;
    std::string location_;
    int64_t id_;
    
    HdfsFileFormat::type file_format_;
};
}

#endif	/* DESCRIPTORS_H */

