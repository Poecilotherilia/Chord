package com.Chord.tool;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Socket {
	public static void receive() throws Exception { 
	        /**1������udp socket�����ý��ն˿�*/
	        
	        DatagramSocket ds = new DatagramSocket(8090);

	        /**2��Ԥ�ȴ������ݴ�ŵ�λ�ã���װ*/
	        byte [] bbuf = new byte [1024];
	         DatagramPacket dp = new DatagramPacket(bbuf,bbuf.length);
	         
	         /**3��ʹ��receive����ʽ����*/
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         ds.receive(dp);
	          
	         System.out.println("ip::"+dp.getAddress().getHostAddress()+"\nport::"+dp.getPort()+"\ndata::"+new String(dp.getData()));
	         
	         /**4���ر���Դ*/
	         ds.close();
	}
	
	public static void Send() throws UnknownHostException, SocketException {
/** 1������udp socket�˵� */
        
        DatagramSocket s = new DatagramSocket(8091);
        
        /** 2���ṩ���ݣ���װ���  ---DatagramPacket(byte[] buf, int length, InetAddress address, int port)  */
        
        byte[] bs = "����ʹ��UDP����--��������! ".getBytes(); 
        DatagramPacket dp = new DatagramPacket(bs, bs.length, InetAddress.getByName("127.0.0.1"), 8071);

        /** 3��ʹ��send���� */
        try {
            s.send(dp);
        } catch (IOException e) {
            System.out.println("����ʧ�ܣ� ");
            e.printStackTrace();
        }
        
        /** 4���ر���Դ */
        s.close();
		
	}
}
