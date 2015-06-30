
#include "service/jni-util.h"

namespace MyMpp {

//void JniUtil::InitLibhdfs() {
  // make random libhdfs calls to make sure that the context class loader isn't
  // null; see xxx for an explanation
  //hdfsFS fs = hdfsConnect("default", 0);
  //hdfsDisconnect(fs);
//}

void JniUtil::LoadJniMethod(JNIEnv* jni_env, const jclass& jni_class, JniMethodDescriptor* descriptor) {
    (*descriptor->method_id) = jni_env->GetMethodID(jni_class,
      descriptor->name.c_str(), descriptor->signature.c_str());
}

}
