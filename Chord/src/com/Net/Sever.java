package com.Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.Chord.tool.Const;

public class Sever implements Runnable{
	DatagramSocket ds;
	SeverDataProcessing dataProcessing;
	
	private ArrayList<DatagramPacket> DataList = new ArrayList<DatagramPacket>();
	
	public Sever() throws Exception {
		ds = new DatagramSocket(Const.PORT);
		
        dataProcessing = new SeverDataProcessing();
        Thread t = new Thread(dataProcessing);
        t.start();
	}
	
	public void run() {
		while(true) {
			try {
				byte [] bbuf = new byte [1024];
				DatagramPacket dp = new DatagramPacket(bbuf,bbuf.length);;
				ds.receive(dp);
				dataProcessing.DataQueue.offer(new String(dp.getData()));
				System.out.println(" ’µΩ ip:"+dp.getAddress().getHostAddress()+" port:"+dp.getPort());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}