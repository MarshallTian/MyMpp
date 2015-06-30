#include "service/frontend.h"
using namespace MyMpp;

int main() {
    Frontend* fe = new Frontend();
    TRequestCtx* requestCtx = new TRequestCtx();
    requestCtx->__set_file_name("hdfs://test0:9000/OS_ORDER.txt");
    fe->GetMddRequest(*requestCtx);
}