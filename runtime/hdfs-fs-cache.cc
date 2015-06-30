#include "runtime/hdfs-fs-cache.h"

using namespace std;

namespace MyMpp {

scoped_ptr<HdfsFsCache> HdfsFsCache::instance_;

void HdfsFsCache::Init() {
  //DCHECK(HdfsFsCache::instance_.get() == NULL);
  HdfsFsCache::instance_.reset(new HdfsFsCache());
}

hdfsFS HdfsFsCache::GetConnection(const std::string& host, int port) {
    lock_guard<mutex> l(lock_);
    HdfsFsMap::iterator i = fs_map_.find(make_pair(host, port));
    if (i == fs_map_.end()) {   
        hdfsBuilder* hdfs_builder = hdfsNewBuilder();
    
        if (!host.empty()) {
          hdfsBuilderSetNameNode(hdfs_builder, host.c_str());
        } else {
          // Connect to local filesystem
          hdfsBuilderSetNameNode(hdfs_builder, NULL);
        }

        hdfsBuilderSetNameNodePort(hdfs_builder, port);
        hdfsFS conn = hdfsBuilderConnect(hdfs_builder);
        
        fs_map_.insert(make_pair(host, port), conn);
        return conn;    
    } else {
        return i->second;
    }
}

hdfsFS HdfsFsCache::GetDefaultConnection() {
    return GetConnection("default", 0);
}

}
