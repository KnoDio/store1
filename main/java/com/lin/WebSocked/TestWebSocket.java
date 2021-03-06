package com.lin.WebSocked;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;

import javax.websocket.OnError;

import javax.websocket.OnMessage;

import javax.websocket.OnOpen;

import javax.websocket.Session;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。

@ServerEndpoint("/websocket/{username}")
public class TestWebSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static ConcurrentHashMap<String,TestWebSocket> webSocketSet = new ConcurrentHashMap<String,TestWebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String username;
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("username") String s, Session session){
        username=s;
        this.session = session;
        System.out.println(s);
        webSocketSet.put("12",this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove("12");  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        sendToUser(message);
    }
    public void sendToUser(String message) {
        System.out.println(message);
        String sendUserno = message.split("[|]")[0];
        String sendMessage = message.split("[|]")[1];
        System.out.println(sendUserno);
        System.out.println(sendMessage);
        try {
            if (webSocketSet.get(sendUserno) != null) {
                webSocketSet.get(sendUserno).sendMessage( "用户" + username + "发来消息:" + sendMessage);
                System.out.println("true");
            } else {
                System.out.println("当前用户不在线");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError

    public void onError(Session session, Throwable error){

        System.out.println("发生错误");

        error.printStackTrace();

    }
    /**

     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。

     * @param message

     * @throws IOException

     */

    public void sendMessage(String message) throws IOException{

       this.session.getBasicRemote().sendText(message);

//        this.session.getAsyncRemote().sendText(message);

    }
    public static synchronized int getOnlineCount() {

        return onlineCount;
    }
    public static synchronized void addOnlineCount() {

        TestWebSocket.onlineCount++;

    }
    public static synchronized void subOnlineCount() {

        TestWebSocket.onlineCount--;

    }
}
