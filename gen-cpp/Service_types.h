/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef Service_TYPES_H
#define Service_TYPES_H

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>



namespace MyMpp {


class TRequestCtx {
 public:

  static const char* ascii_fingerprint; // = "EFB929595D312AC8F305D5A794CFEDA1";
  static const uint8_t binary_fingerprint[16]; // = {0xEF,0xB9,0x29,0x59,0x5D,0x31,0x2A,0xC8,0xF3,0x05,0xD5,0xA7,0x94,0xCF,0xED,0xA1};

  TRequestCtx() : file_name() {
  }

  virtual ~TRequestCtx() throw() {}

  std::string file_name;

  void __set_file_name(const std::string& val) {
    file_name = val;
  }

  bool operator == (const TRequestCtx & rhs) const
  {
    if (!(file_name == rhs.file_name))
      return false;
    return true;
  }
  bool operator != (const TRequestCtx &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const TRequestCtx & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

};

void swap(TRequestCtx &a, TRequestCtx &b);

} // namespace

#endif
