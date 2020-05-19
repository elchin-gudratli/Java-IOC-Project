package com.bilgeadam.odeme.kotu;

public class Test {

	public static void main(String[] args) {
		KrediKarti   k=new KrediKarti();
		
		
		OdemeIslemi  od=new OdemeIslemi(k);
		
		od.OdemeYap(50.00);

	}

}
