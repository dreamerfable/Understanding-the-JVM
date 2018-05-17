package com.dreamer.bookcode.utj.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致内存溢出 - before JDK 1.7
 * 
 * <pre>
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * </pre>
 * 
 * @author 高强
 */
public class RuntimeConstantPoolOOM {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }

}
