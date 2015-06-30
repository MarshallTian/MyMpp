#include "service/frontend.h"

#include <list>
#include <string>

using namespace MyMpp;
using namespace std;

namespace MyMpp {
Frontend::Frontend() {
    JniMethodDescriptor methods[] = {
        {"<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;"
        "Ljava/lang/String;II)V", &fe_ctor_},
        {"createMddRequest", "([B)[B", &create_mdd_request_id_}};
    
    JNIEnv* jni_env = JniUtil::getJNIEnv();
    
    fe_class_ = jni_env->FindClass("MyMpp/HdfsMDD");
    
    if (fe_class_ == NULL) {
        printf("Not find!\n");
        exit(1);
    }
    
    uint32_t num_methods = sizeof(methods) / sizeof(methods[0]);
    
    for (int i = 0; i < num_methods; ++i) {
        JniUtil::LoadJniMethod(jni_env, fe_class_, &(methods[i]));
    }
    printf("loading over!\n");
    
    std::string server_name;
    
    //jboolean lazy = false;
    fe_ = jni_env->NewObject(fe_class_, fe_ctor_, false);
    
    if (fe_ == 0)
    {
	printf("Create object failed!\n");
    }
    printf("Alloc over!\n");
    
    
}

void Frontend::GetMddRequest(const TRequestCtx& request_ctx) {
    JniUtil::CallJniMethod(fe_, create_mdd_request_id_, request_ctx);
}
}
