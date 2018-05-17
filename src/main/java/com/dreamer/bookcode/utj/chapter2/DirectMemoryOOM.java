package com.dreamer.bookcode.utj.chapter2;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 本机直接内存溢出
 * 
 * <pre>
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * </pre>
 * 
 * @author 高强
 */
@SuppressWarnings("restriction")
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }

}