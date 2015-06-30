#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=GNU-Linux-x86
CND_DLIB_EXT=so
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/Service/JniTest.o \
	${OBJECTDIR}/Service/frontend.o \
	${OBJECTDIR}/Service/jni-util.o \
	${OBJECTDIR}/Service/thrift-util.o \
	${OBJECTDIR}/common/atomic-test.o \
	${OBJECTDIR}/hdfs-scan-node.o \
	${OBJECTDIR}/hdfs-text-scanner.o \
	${OBJECTDIR}/hdfs-text-scanner.cc.o \
	${OBJECTDIR}/runtime/hdfs-fs-cache.o


# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-L/opt/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0 /opt/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/libgtest.a /opt/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/libgtest_main.a -lboost_thread

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp: /opt/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/libgtest.a

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp: /opt/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/libgtest_main.a

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp ${OBJECTFILES} ${LDLIBSOPTIONS}

${OBJECTDIR}/Service/JniTest.o: Service/JniTest.cc 
	${MKDIR} -p ${OBJECTDIR}/Service
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Service/JniTest.o Service/JniTest.cc

${OBJECTDIR}/Service/frontend.o: Service/frontend.cc 
	${MKDIR} -p ${OBJECTDIR}/Service
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Service/frontend.o Service/frontend.cc

${OBJECTDIR}/Service/jni-util.o: Service/jni-util.cc 
	${MKDIR} -p ${OBJECTDIR}/Service
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Service/jni-util.o Service/jni-util.cc

${OBJECTDIR}/Service/thrift-util.o: Service/thrift-util.cc 
	${MKDIR} -p ${OBJECTDIR}/Service
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/Service/thrift-util.o Service/thrift-util.cc

${OBJECTDIR}/common/atomic-test.o: common/atomic-test.cc 
	${MKDIR} -p ${OBJECTDIR}/common
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/common/atomic-test.o common/atomic-test.cc

${OBJECTDIR}/hdfs-scan-node.o: hdfs-scan-node.cc 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/hdfs-scan-node.o hdfs-scan-node.cc

${OBJECTDIR}/hdfs-text-scanner.o: hdfs-text-scanner.cc 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/hdfs-text-scanner.o hdfs-text-scanner.cc

${OBJECTDIR}/hdfs-text-scanner.cc.o: hdfs-text-scanner.cc.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/hdfs-text-scanner.cc.o hdfs-text-scanner.cc.cpp

${OBJECTDIR}/runtime/hdfs-fs-cache.o: runtime/hdfs-fs-cache.cc 
	${MKDIR} -p ${OBJECTDIR}/runtime
	${RM} "$@.d"
	$(COMPILE.cc) -g -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gtest-1.6.0/include -I. -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src/glog -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/src/gflags -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/gflags-2.0/third-party-install/include -I../../impala/Impala-cdh5.1.0_v1.4/thirdparty/glog-0.3.2/src -I/home/code/MyMpp -include . -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/runtime/hdfs-fs-cache.o runtime/hdfs-fs-cache.cc

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}
	${RM} ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/mympp

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
