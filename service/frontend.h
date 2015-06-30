/* 
 * File:   Frontend.h
 * Author: root
 *
 * Created on June 25, 2015, 5:19 PM
 */

#ifndef FRONTEND_H
#define	FRONTEND_H

#include <jni.h>
#include "service/jni-util.h"
#include "service/thrift-util.h"
#include "gen-cpp/Service_types.h"

namespace MyMpp {
class Frontend {
public:
    Frontend();
    
    void GetMddRequest(const TRequestCtx& request_ctx);
    
private:
    jclass fe_class_;
    
    jobject fe_;
    jmethodID create_mdd_request_id_; 
    jmethodID fe_ctor_;
    
};

}

#endif	/* FRONTEND_H */

