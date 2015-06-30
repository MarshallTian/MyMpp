#include <boost/shared_ptr.hpp>
#include <boost/thread.hpp>

#include "service/thrift-util.h"

#ifdef UNLIKELY
#undef UNLIKELY
#endif
#define SIGNED_RIGHT_SHIFT_IS 1
#define ARITHMETIC_RIGHT_SHIFT 1

#include <thrift/Thrift.h>
#include <thrift/transport/TSocket.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/concurrency/ThreadManager.h>
#include <thrift/concurrency/PosixThreadFactory.h>
#include <thrift/protocol/TCompactProtocol.h>

using namespace std;
using namespace apache::thrift;
using namespace apache::thrift::transport;
using namespace apache::thrift::protocol;
using namespace apache::thrift::concurrency;
using namespace boost;

namespace MyMpp {

ThriftSerializer::ThriftSerializer(bool compact, int initial_buffer_size) :
mem_buffer_(new TMemoryBuffer(initial_buffer_size)) {
    if (compact) {
        TCompactProtocolFactoryT<TMemoryBuffer> factory;
        protocol_ = factory.getProtocol(mem_buffer_);
    } else {
        TBinaryProtocolFactoryT<TMemoryBuffer> factory;
        protocol_ = factory.getProtocol(mem_buffer_);
    }
}
}
