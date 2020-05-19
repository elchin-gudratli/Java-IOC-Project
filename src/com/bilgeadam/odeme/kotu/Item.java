package com.bilgeadam.odeme.kotu;

public class Item {

	@Override
	public String toString() {
		return Aciklama;
	}

	private String Adi;

	private String Aciklama;
	

	public Item(String Adi, String Aciklama) {
		this.Adi = Adi;
		this.Aciklama = Aciklama;
	}

	
	public String getAdi() {
		return Adi;
	}

	public void setAdi(String adi) {
		Adi = adi;
	}

	public String getAciklama() {
		return Aciklama;
	}

	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}
	
	


	
}