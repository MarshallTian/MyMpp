/* 
 * File:   hdfs-fs-cache.h
 * Author: root
 *
 * Created on June 24, 2015, 8:21 PM
 */

#ifndef HDFS_FS_CACHE_H
#define	HDFS_FS_CACHE_H

#include <string>
#include <boost/scoped_ptr.hpp>
#include <boost/unordered_map.hpp>
#include <boost/thread/mutex.hpp>
#include <hdfs.h>

namespace MyMpp {

class HdfsFsCache {
public:
    static HdfsFsCache* instance() { return HdfsFsCache::instance_.get(); }
    
    void Init();
    
    hdfsFS GetDefaultConnection();
    
    hdfsFS GetConnection(const std::string& host, int port);
    
private:
    static boost::scoped_ptr<HdfsFsCache> instance_;
    
    boost::mutex lock_;
    
    typedef boost::unordered_map<std::pair<std::string, int>, hdfsFS> HdfsFsMap;
    HdfsFsMap fs_map_;
    
    HdfsFsCache() { };
};
}


#endif	/* HDFS_FS_CACHE_H */

