#include "service/frontend.h"
using namespace MyMpp;

int main() {
    Frontend* fe = new Frontend();
    TRequestCtx* requestCtx = new TRequestCtx();
    requestCtx->__set_file_name("/ORDER.txt");
    fe->GetMddRequest(*requestCtx);
}