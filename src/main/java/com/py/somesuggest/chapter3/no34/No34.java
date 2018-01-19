package com.py.somesuggest.chapter3.no34;

/**
 * 构造函数尽量简化
 * 构造函数简化，再简化，应该达到”一眼洞穿“的境界
 *
 * @author Administrator
 * @date 2017/9/21 0021
 */
public class No34 {
    public static void main(String[] args) {
        AbstractServer s = new SimpleServer(1000);
        s.start();
    }
}

/**
 * 定义一个服务
 */
abstract class AbstractServer {
    public final static int DEFAULT_PORT = 40000;

    public AbstractServer() {
        //NOT DO THIS 不应该在构造函数实现复杂逻辑
//        //获得子类提供的端口号
//        int port = getPort();
//        System.out.println("端口号：" + port);     //端口号：40000或者端口号：0(父类构造函数调用被覆写的getPort()方法时，子类的port属性还未初始化，所以是0)
//        /*进行监听动作*/
    }
    public void start(){
        //获得子类提供的端口号
        int port = getPort();
        System.out.println("端口号：" + port);
    }

    /**
     * 获取端口号
     * @return
     */
    protected abstract int getPort();
}

class SimpleServer extends AbstractServer {
    private int port = 100;

    /**
     * 初始化传递一个端口号
     */
    public SimpleServer(int port) {
        this.port = port;
    }

    //检查端口号是否有效，无效则使用默认端口，这里使用随机数模拟
    @Override
    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}
