package com.Chord.data;

import com.Chord.tool.Const;
import com.Chord.tool.Tool;

public class FingerTable {
	private Finger[] table;
	
	FingerTable(Address addr){
		table = new Finger[Const.RING_LOC_DIGIT];
		System.out.println(Const.RING_LOC_LIST.length);
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			table[i] = new Finger(Tool.AddLocal(addr.HashCode(), Const.RING_LOC_LIST[i]),null);
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
		if(table[temp].addr == null) {
			for(int i = temp;i>=0;i--) {
				if(table[i].addr != null) {
					temp = i;
					break;
				}
			}
		}
		System.out.println(table[temp].local);
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
			if((aimAddr.HashCode() >= table[i].local && table[i].addr == null)||
					(aimAddr.HashCode() >= table[i].local && aimAddr.HashCode() < table[i].addr.HashCode())) {
				table[i].addr =  new Address(aimAddr.GetString());
			}
		}
		
	}
	
	public boolean IsTableFull() {
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			if(table[i].addr == null) {
				return false;
			}
		}
		return true;
	}
	
	public void PringTable() {
		System.out.println("********************************************************************");
		for(int i=0;i<Const.RING_LOC_DIGIT;i++) {
			if(table[i].addr != null) {
			System.out.println("local:" + table[i].local+" address:"+table[i].addr.GetString());
			}else {
				System.out.println("local:" + table[i].local+" address: null");
			}
		}
		System.out.println("********************************************************************");
	}
}
