package com.dreamer.bookcode.utj.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * 
 * <pre>
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * </pre>
 * 
 * @author 高强
 * @version 1.0
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
