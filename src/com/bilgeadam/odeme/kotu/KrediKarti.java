package com.bilgeadam.odeme.kotu;

public class KrediKarti implements IOdemeTipi{
	
	@Override
	public void OdemeYap(double tutar) {
		
		System.out.println("Kredi Karti ile "+tutar+" Tl odeme alindi");
	}

}
