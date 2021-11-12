package j2p;


import cn.kloping.string.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * java 调用 python
 * 这个就比较简单
 * 不需要苛刻的要求
 * 运行环境 jdk 8+
 * 有两种方法
 * 第二种 Runtime
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        String arg = " Java传入参数";

        String line=null;
        BufferedReader in=null;
        Process proc=null;

        String pythonPath = null;

        pythonPath = "E:\\development_environment\\Python3.9.8\\python.exe";
        //这方法不知道为什么找到 python 未知 建议直接使用绝对路径
//        proc = Runtime.getRuntime().exec(new String[]{"where", "python"});
//        in = new BufferedReader(new InputStreamReader(proc.getInputStream(), Charset.forName("GBK")));
//        line = null;
//        while ((line = in.readLine()) != null) {
//            pythonPath = line.trim();
//            break;
//        }
//        in = new BufferedReader(new InputStreamReader(proc.getErrorStream(), Charset.forName("GBK")));
//        line = null;
//        while ((line = in.readLine()) != null) {
//            System.err.println(line);
//        }
        args = new String[]{pythonPath, new File("./src/main/java/j2p/py/__init__.py").getAbsolutePath()
                , arg};

        proc = Runtime.getRuntime().exec(args);
        proc.waitFor();
        in = new BufferedReader(new InputStreamReader(proc.getInputStream(), Charset.forName("GBK")));
        line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in = new BufferedReader(new InputStreamReader(proc.getErrorStream(), Charset.forName("GBK")));
        line = null;
        while ((line = in.readLine()) != null) {
            System.err.println(line);
        }
        in.close();
        proc.waitFor();
    }
}
