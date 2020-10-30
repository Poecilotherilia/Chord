package com.Chord.tool;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Socket {
	public static void receive() throws Exception { 
	        /**1、建立udp socket，设置接收端口*/
	        
	        DatagramSocket ds = new DatagramSocket(8090);

	        /**2、预先创建数据存放的位置，封装*/
	        byte [] bbuf = new byte [1024];
	         DatagramPacket dp = new DatagramPacket(bbuf,bbuf.length);
	         
	         /**3、使用receive阻塞式接收*/
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         /**4、关闭资源*/
	         ds.close();
	}
	
	public static void Send() throws UnknownHostException, SocketException {
/** 1、建立udp socket端点 */
        
        DatagramSocket s = new DatagramSocket(8091);
        
        /** 2、提供数据，封装打包  ---DatagramPacket(byte[] buf, int length, InetAddress address, int port)  */
        
        byte[] bs = "正在使用UDP发送--我是数据! ".getBytes(); 
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("127.0.0.1"), 8071);

        /** 3、使用send发送 */
        try {
            s.send(dp);
        } catch (IOException e) {
            System.out.println("发送失败： ");
            e.printStackTrace();
        }
        
        /** 4、关闭资源 */
        s.close();
		
	}
}
