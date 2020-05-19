package com.bilgeadam.odeme.kotu;

public class OdemeIslemiFactory {
	
	@SuppressWarnings("rawtypes")
	public IOdemeTipi create(String name) throws InstantiationException, IllegalAccessException {
		
	
		Class c;
		IOdemeTipi iOdemeTipi = null;
		try
		{
			c = Class.forName("com.bilgeadam.odeme.kotu."+name);
			iOdemeTipi = (IOdemeTipi) c.newInstance();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return iOdemeTipi;
	}

}
