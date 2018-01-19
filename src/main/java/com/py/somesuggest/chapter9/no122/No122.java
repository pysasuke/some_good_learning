package com.py.somesuggest.chapter9.no122;

/**
 * 使用线程异常处理器提升系统可靠性
 *
 * @author Administrator
 * @date 2017/11/15 0015
 */
public class No122 {
    public static void main(String[] args) {
        new TcpServer();
    }
}

class TcpServer implements Runnable {
    /**
     * 创建后即运行
     */
    public TcpServer() {
        Thread t = new Thread(this);
        //设置该线程出现运行期异常(也就是Uncaught Exception)时，由TcpServerExceptionHandler异常处理器来处理
        t.setUncaughtExceptionHandler(new TcpServerException());
        t.start();
    }

    @Override
    public void run() {
        //正常业务进行，运行3秒
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("系统正常运行:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //抛出异常
        throw new RuntimeException();
    }

    private static class TcpServerException implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            //记录线程异常信息
            System.out.println("线程" + t.getName() + "出现异常，自行重启，请分析原因。");
            e.printStackTrace();
            //重启线程，保证业务不中断
            //当Thread-0出现异常时，系统自动启动Thread-1线程，继续提供服务
            new TcpServer();
        }
    }
}
/*
系统正常运行:0
系统正常运行:1
系统正常运行:2
线程Thread-0出现异常，自行重启，请分析原因。
java.lang.RuntimeException
	at com.py.somesuggest.chapter9.no122.TcpServer.run(No112.java:34)
	at java.lang.Thread.run(Thread.java:745)
系统正常运行:0
系统正常运行:1
系统正常运行:2
java.lang.RuntimeException
线程Thread-1出现异常，自行重启，请分析原因。
	at com.py.somesuggest.chapter9.no122.TcpServer.run(No112.java:34)
	at java.lang.Thread.run(Thread.java:745)
系统正常运行:0
 */