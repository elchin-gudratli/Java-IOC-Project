package com.bilgeadam.odeme.kotu;

public class SmsOdeme implements IOdemeTipi{
	
	
	@Override
	public void OdemeYap(double tutar) {
		
		System.out.println("Smsle "+tutar+" Tl odeme alindi");
	}

}
