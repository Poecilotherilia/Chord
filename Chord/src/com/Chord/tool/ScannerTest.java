package com.Chord.tool;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Scanner;

import com.Chord.data.Node;

public class ScannerTest implements Runnable{
	public void run() {
		 Scanner scan = new Scanner(System.in);
		while(true) {
		        // nextLine��ʽ�����ַ���
		        System.out.println("nextLine��ʽ���գ�");
		        // �ж��Ƿ�������
		        if (scan.hasNextLine()) {
		            String str2 = scan.nextLine();
		            Node.Instance().fingerTable.PringTable();
		            System.out.println(Node.Instance().predecessor.GetString()+" "+Node.Instance().successor.GetString());
		        }
		}
	}
}