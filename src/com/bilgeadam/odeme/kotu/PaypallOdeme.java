package com.bilgeadam.odeme.kotu;

public class PaypallOdeme implements IOdemeTipi {

	@Override
	public void OdemeYap(double tutar) {
		System.out.println("Paypall "+tutar+" Odemeniz Yapilmisdir");
		
	}
	
	

}
