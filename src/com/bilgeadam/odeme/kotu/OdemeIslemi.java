package com.bilgeadam.odeme.kotu;

public class OdemeIslemi {
	
	private IOdemeTipi iOdemeTipi;
	
	
	
	public OdemeIslemi(IOdemeTipi iOdemeTipi) {
		this.iOdemeTipi=iOdemeTipi;
		
	}
	
	
	public void OdemeYap(double tutar) {
		iOdemeTipi.OdemeYap(tutar);
		
	}

}
