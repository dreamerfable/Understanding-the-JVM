package com.dreamer.bookcode.utj.chapter2;

/**
 * 创建线程导致内存溢出
 * 
 * <pre>
 * -Xss2M
 * </pre>
 * 
 * @author 高强
 * @deprecated 这个类执行有导致操作系统假死的危险
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
            // do nothing
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    dontStop();
                }

            });
            thread.start();
        }
    }

    public static void main(String[] args) {

        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();

    }

}
