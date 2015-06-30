/* 
 * File:   thrift-util.h
 * Author: root
 *
 * Created on June 26, 2015, 10:18 AM
 */

#ifndef THRIFT_UTIL_H
#define	THRIFT_UTIL_H

#include <boost/shared_ptr.hpp>
#include <thrift/protocol/TBinaryProtocol.h>
#include <sstream>
#include <vector>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TDebugProtocol.h>
#include <thrift/transport/TBufferTransports.h>

#include "gen-cpp/Service_types.h"

namespace MyMpp {

class ThriftSerializer {
public:
    ThriftSerializer(bool compact, int initial_buffer_size = 1024);
    
    template <class T>
    void Serialize(const T* obj, uint32_t* len, uint8_t** buffer) {
      try {
        mem_buffer_->resetBuffer();
        obj->write(protocol_.get());
      } catch (std::exception& e) {
        std::stringstream msg;
        msg << "Couldn't serialize thrift object:\n" << e.what();
        //return Status(msg.str());
        return;
      }
      mem_buffer_->getBuffer(buffer, len);
      //return Status::OK;
    }
    
private:
    boost::shared_ptr<apache::thrift::transport::TMemoryBuffer> mem_buffer_;
    boost::shared_ptr<apache::thrift::protocol::TProtocol> protocol_;
};

}

#endif	/* THRIFT_UTIL_H */

