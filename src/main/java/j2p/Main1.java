package j2p;

import cn.kloping.file.FileUtils;
import org.python.core.Py;
import org.python.util.PythonInterpreter;

/**
 * java 调用 python
 * 这个就比较简单
 * 不需要苛刻的要求
 * 运行环境 jdk 8+
 * 有两种方法
 * 第一种 pom 依赖
 *
 */
public class Main1 {
    public static final PythonInterpreter interpreter = new PythonInterpreter();

    public static void main(String[] args) {
        String[] commands = FileUtils.getStringsFromFile("./src/main/java/j2p/py/__init__.py");
        StringBuffer sb = new StringBuffer();
        for (String l : commands) {
            String command = l + "\n";
            sb.append(command);
        }
        interpreter.exec(Py.newStringUTF8(sb.toString()));

        m1();
        m2("Java 传入参数");
    }

    public static void m1() {
        interpreter.exec("print(m1());");
    }

    public static void m2(String arg) {
        interpreter.exec(Py.newStringUTF8("print(m2(\"" + arg + "\"));"));
    }
}
