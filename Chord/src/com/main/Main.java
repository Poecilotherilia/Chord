package com.main;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.Scanner;

import com.Chord.data.Node;
import com.Chord.tool.Const;
import com.Chord.tool.SHA1;
import com.Chord.tool.ScannerTest;
import com.Net.Client;
import com.Net.PacketType;
import com.Net.Sever;
import com.alibaba.fastjson.*;

public class Main {
	static Method event ;
	
	public static void main(String[] args) throws Exception {

        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: "+addr.getHostAddress() +" "+ Const.RING_LOC_LIST[2]);
        Sever sever = new Sever();
	    Thread t = new Thread(sever);
	    t.start();
	    
	    ScannerTest test = new ScannerTest();
	    Thread t1 = new Thread(test);
	    t1.start();
	    
        Node.CreateNewNode("127.0.0.1",Const.PORT,"127.0.0.1:15698");
        event = Node.class.getMethod("a", String.class);
        event.invoke(Node.Instance(), "aaa");
        Node.Instance().FindFile(fileLoc, onFindFile, instance);
    }
	

}
