package com.Chord.data;

import com.Chord.tool.Const;
import com.Chord.tool.Tool;

public class FingerTable {
	private Finger[] table;
	
	FingerTable(Address addr){
		table = new Finger[Const.RING_LOC_DIGIT];
		System.out.println(Const.RING_LOC_LIST.length);
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			table[i] = new Finger(Tool.AddLocal(addr.HashCode(), Const.RING_LOC_LIST[i]),new Address(addr.GetString()));
		}
	}
	
	public void SetTable(int i,Address aimAddr) {
		table[i].addr = aimAddr;
	}
	
	public Finger SearchWithHash(long hash) {
		int temp = 0;
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			if(hash > table[i].local) {
				temp = i;
			}else {
				break;
			}
		}
		return table[temp];
	}
	
	public int GetTableNum(long hash) {
		int temp = 0;
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			if(hash >= table[i].local) {
				temp = i;
			}else {
				break;
			}
		}
		return temp;
	}
	
	public long GetTableLoc(int i) {
		return table[i].local;
	}
	
	public void Update(Address aimAddr) {
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			if(aimAddr.HashCode() >= table[i].local && aimAddr.HashCode() < table[i].addr.HashCode()) {
				table[i].addr =  new Address(aimAddr.GetString());
			}
		}
		
	}
}
