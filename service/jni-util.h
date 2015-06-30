/* 
 * File:   jni-util.h
 * Author: root
 *
 * Created on June 25, 2015, 5:30 PM
 */

#ifndef JNI_UTIL_H
#define	JNI_UTIL_H

#include <jni.h>
#include <string>
#include <vector>
#include "service/thrift-util.h"
#include "gen-cpp/Service_types.h"

extern  "C" { extern JNIEnv* getJNIEnv(void); }

namespace MyMpp {

struct JniMethodDescriptor {
  // Name of the method, case must match
  const std::string name;

  // JNI-style method signature
  const std::string signature;

  // Handle to the method
  jmethodID* method_id;
};

class JniUtil {
    //void JniUtil::InitLibhdfs();
public:
    static JNIEnv* getJNIEnv() {
        
        const jsize vmBufLength = 1;
        JavaVM* vmBuf[vmBufLength]; 
        JNIEnv *env;
        jint rv = 0; 
        jint noVMs = 0;
        
        rv = JNI_GetCreatedJavaVMs(&(vmBuf[0]), vmBufLength, &noVMs);
        
        if (noVMs != 0) {
            JavaVM* vm = vmBuf[0];
            rv = vm->AttachCurrentThread((void **)&env, 0);
            if (rv != 0) {
                fprintf(stderr, "Call to AttachCurrentThread "
                        "failed with error: %d\n", rv);
                //UNLOCK_JVM_MUTEX();
                return NULL;
            }
            printf("Return Env!");
            return env;
        }
            
         
        printf("NoVMs is %d\n", noVMs); 
        JavaVMOption options[2];
        //JNIEnv *env;
        JavaVM *jvm;
        JavaVMInitArgs vm_args;
        
        options[0].optionString = (char *)"-Djava.compiler=NONE";
        //options[1].optionString = (char *)"-Djava.class.path=/opt/jdk1.7.0_67/lib/:.";
        options[1].optionString = (char *)"-Djava.class.path=/home/code/MyMpp/fe/target/classes/:"
                "/home/code/MyMpp/fe/fe.jar:"
                "/home/code/MyMpp/fe/target/dependency/libthrift-0.9.0.jar:/home/code/MyMpp/fe/target/dependency/slf4j-log4j12-1.7.5.jar:"
                "/home/code/MyMpp/fe/target/dependency/slf4j-api-1.7.5.jar:"
                "/home/code/MyMpp/fe/target/dependency/hadoop-hdfs-2.3.0.jar:"
                "/home/code/MyMpp/fe/target/dependency/log4j-1.2.17.jar";
        //options[2].optionString = (char *)"-Djava.library.path=/home/code/MyMpp/fe/target/dependency/hadoop-hdfs-2.3.0.jar";
        
        memset(&vm_args, 0, sizeof(vm_args));
        vm_args.version = JNI_VERSION_1_2;
        vm_args.nOptions = 2;
        vm_args.options = options;
        
        long status = JNI_CreateJavaVM(&jvm, (void**) &env, &vm_args); 
        if (status != JNI_ERR)
        {
            jclass cls = env->FindClass("MyMpp/service/JniFrontend");
            if (cls == 0)
                printf("Not find ...\n");
            
            jthrowable exc;
            exc = env->ExceptionOccurred();
                 if (exc) {
                     jclass newExcCls;
                     env->ExceptionDescribe();
                     env->ExceptionClear();

                 }
            printf("Success to create Jvm\n");
            return env;
        }
        else { exit(-1); }
    }
    
    static void LoadJniMethod(JNIEnv* jni_env, const jclass& jni_class,
      JniMethodDescriptor* descriptor);
    
    template <typename T>
    static void CallJniMethod(const jobject& obj, const jmethodID& method, const T& arg) {
        JNIEnv* jni_env = getJNIEnv();
        printf("Get over!");
        jbyteArray request_bytes;
      
        SerializeThriftMsg(jni_env, &arg, &request_bytes);
        printf("Set over!");
        //SerializeThriftMsg(jni_env, &arg, request_bytes);
        
        jni_env->CallVoidMethod(obj, method, request_bytes);
        //jni_env->CallObjectMethod(obj, method, request_bytes);
    }
};

}

#endif	/* JNI_UTIL_H */

