package com.dreamer.bookcode.utj.chapter2;

/**
 * VM Stack 和 Native Method Stack 溢出
 * 
 * <pre>
 * -Xss128k
 * </pre>
 * 
 * @author 高强
 */
public class JavaVMStackOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOF oom = new JavaVMStackOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
