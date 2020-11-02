package com.Chord.tool;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;

import com.Chord.data.Node;

public class ScannerTest implements Runnable{
	public void run() {
		 Scanner scan = new Scanner(System.in);
		while(true) {
		        // nextLine方式接收字符串
		        System.out.println("nextLine方式接收：");
		        // 判断是否还有输入
		        if (scan.hasNextLine()) {
		            String str2 = scan.nextLine();
		            Node.Instance().fingerTable.PringTable();
		            System.out.println(Node.Instance().addr.HashCode()+" "+Node.Instance().addr.GetString()+" "+Node.Instance().predecessor.GetString()+" "+Node.Instance().successor.GetString());
		        }
		}
	}
}
