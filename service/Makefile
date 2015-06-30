INCLUDE_OPTS = -I/home/code/MyMpp/ \
	-I/opt/jdk1.7.0_67/include/ \
	-I/opt/jdk1.7.0_67/include/linux \
	-I/usr/local/include/boost \
	-I/root/thrift/include

LIB_OPTS = -lthrift -ljvm
#	-L/opt/jdk1.7.0_67/jre/lib/amd64/server/libjvm.so\
#	-L/opt/jdk1.7.0_67/jre/lib/amd64/libjava.so 

SRC_FILES = JniTest.cc \
	jni-util.cc \
	thrift-util.cc \
	frontend.cc \
	../gen-cpp/Service_types.cpp \

CCFLAGS =  -DHAVE_NETINET_IN_H -g -O -DMPICH_IGNORE_CXX_SEEK
 
default:
	g++ ${CCFLAGS} -o filetext ${SRC_FILES} ${INCLUDE_OPTS} ${LIB_OPTS}	
