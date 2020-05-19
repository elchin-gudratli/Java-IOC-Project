package com.bilgeadam.odeme.kotu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OdemeIslemiFormu {

	private JFrame frame;
	private JTextField txtTutar;
	private OdemeIslemi odemeIslemi;
	JComboBox cmbOdemeTipi;
	String ClassAdi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdemeIslemiFormu window = new OdemeIslemiFormu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OdemeIslemiFormu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOdemeTipi = new JLabel("Odeme Tipi :");
		lblOdemeTipi.setBounds(23, 42, 111, 16);
		frame.getContentPane().add(lblOdemeTipi);
		
		cmbOdemeTipi = new JComboBox();
		cmbOdemeTipi.addActionListener(e -> 
		{
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
			ClassAdi = item.getAdi();
		
		});
		//cmbOdemeTipi.setModel(new DefaultComboBoxModel(new String[] {"Seciniz...", "KrediKarti", "SmsOdeme", "PaypallOdeme", "CoinOdeme"}));
		cmbOdemeTipi.setBounds(159, 38, 211, 27);
		frame.getContentPane().add(cmbOdemeTipi);
		
		JLabel lblTutar = new JLabel("Tutar : ");
		lblTutar.setBounds(23, 110, 111, 16);
		frame.getContentPane().add(lblTutar);
		
		txtTutar = new JTextField();
		txtTutar.setBounds(159, 105, 211, 26);
		frame.getContentPane().add(txtTutar);
		txtTutar.setColumns(10);
		
		JButton btnOdemeYap = new JButton("Odeme Yap");
		btnOdemeYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if(cmbOdemeTipi.getSelectedItem().toString().equals("Seciniz")) 
				{
					System.out.println("Lutfen Odeme Tipi Seciniz");
				}
				else if(cmbOdemeTipi.getSelectedItem().toString().equals("KrediKarti"))	
				{
					KrediKarti  k =new KrediKarti();
					k.OdemeYap(Double.valueOf(txtTutar.getText()));
				}
				else if(cmbOdemeTipi.getSelectedItem().toString().equals("SmsOdeme")) 
				{
					SmsOdeme s=new SmsOdeme();
					s.OdemeYap(Double.valueOf(txtTutar.getText()));
				}
				*/

				if(cmbOdemeTipi.getSelectedItem().toString().equals("Seciniz")) 
				{
					System.out.println("Lutfen Odeme Tipi Seciniz");
				}
				OdemeIslemiFactory odemeFactory = new OdemeIslemiFactory();
				IOdemeTipi iOdemeTipi;
				try
				{
					iOdemeTipi = odemeFactory.create(ClassAdi);
					
				    odemeIslemi = new OdemeIslemi(iOdemeTipi);
					
					odemeIslemi.OdemeYap(Double.valueOf(txtTutar.getText()));
				}
				catch(InstantiationException ex) {
					ex.printStackTrace();
				}
				catch(IllegalAccessException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnOdemeYap.setBounds(239, 187, 131, 49);
		frame.getContentPane().add(btnOdemeYap);
		OdemiTipiGetir(); 
	}
	
	@SuppressWarnings("unchecked")
	public void OdemiTipiGetir() {
		cmbOdemeTipi.removeAllItems();
		try 
		{

			String db = "jdbc:mysql://52.117.236.126/mysql";
			Connection conn = DriverManager.getConnection(db, "root", "123");
			String sorgu = "SELECT * FROM OdemeTipi";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			cmbOdemeTipi.addItem(new Item("", "Ödeme Tipi Seçiniz."));
			while (rs.next()) {

				cmbOdemeTipi.addItem(new Item(rs.getString("Adi"), rs.getString("Aciklama")));

			}

			st.close();
			conn.close();
		}

		catch (Exception a) {
			System.err.println("Hata ! ");
			System.err.println(a.getMessage());
		}

	}
	@SuppressWarnings("unchecked")
	public void OdemeTipiGetir() {
		try 
		{

			String db = "jdbc:mysql://52.117.236.126/mysql";
			Connection conn = DriverManager.getConnection(db, "root", "123");
			String sorgu = "SELECT * FROM OdemeTipi";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			cmbOdemeTipi.addItem(new Item("", "Ödeme Tipi  Seçiniz."));
			while (rs.next()) {

				cmbOdemeTipi.addItem(new Item(rs.getString("Adi"), rs.getString("Aciklama")));

			}

			st.close();
			conn.close();
		}

		catch (Exception a) {
			System.err.println("Hata ! ");
			System.err.println(a.getMessage());
		}

	}
}
