#include "library.h"

#include <iostream>

using namespace std;

extern const char *m1() {
    return "cpp 内部返回值";
}

extern void m2(char string[]) {
    cout << "cpp Out :" << string << "\0" << endl;
}
