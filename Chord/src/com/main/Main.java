package com.main;

import java.security.MessageDigest;

import com.Chord.tool.SHA1;
import com.Chord.tool.Socket;
import com.alibaba.fastjson.*;

public class Main {
	public static void main(String[] args) throws Exception {
        System.out.println("Hello World" + SHA1.GetHash("989989"));
        //Socket.Send();
        //Socket.receive();
        //System.out.println("Hello World" + SHA1.GetHash("989989"));
        JSONObject json = new JSONObject();
        json.put("a", 1);
        json.put("2", "b");
        System.out.println(json.toJSONString());
    }
}