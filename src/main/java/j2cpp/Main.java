package j2cpp;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * java 与 cpp 语言的相互调用
 * jdk 8 x32
 * cpp 目录下源码 和 编译后的 dll
 *
 * 关于 cpp 调 java 还没学会 有点难度 加上 我对 c/c++/c# 不大了解
 * 学会了再来 填坑
 */
public class Main {
    public interface callJavaE extends Library {
        callJavaE INSTANCE = (callJavaE) Native.load(("./src/main/java/j2cpp/cpp/libCppLibs.dll"), callJavaE.class);

        String _Z2m1v();

        String _Z2m2Pc(String str);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(callJavaE.INSTANCE);
        System.out.println(callJavaE.INSTANCE._Z2m1v());
        callJavaE.INSTANCE._Z2m2Pc("Java调用测试");
    }

    public static String method() {
        return "Java内部方法返回值";
    }
}