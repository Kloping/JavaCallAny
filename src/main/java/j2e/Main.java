package j2e;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * java 与 e语言的相互调用
 * jdk 8 x32
 * 由于 IDEA 无法查看 e 语言 源码
 * 所以 截了图 请看 当前目录下 e 目录下 img.png 对应的 callJava.e的源码
 * 静态编译后 为 m1.dll
 */
public class Main {
    public interface callJavaE extends Library {
        callJavaE INSTANCE = (callJavaE) Native.load(("./src/main/java/j2e/e/m1.dll"), callJavaE.class);

        String m1();

        String m2(String str);
    }

    public static void main(String[] args) throws Exception {
        //防止乱码
        System.setProperty("jna.encoding", "GBK");
        System.out.println(callJavaE.INSTANCE);
        System.out.println(callJavaE.INSTANCE.m1());
        System.out.println(callJavaE.INSTANCE.m2("Java 调用 测试"));
    }

    public static String method() {
        return "Java内部方法返回值";
    }
}
