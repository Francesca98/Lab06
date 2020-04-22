package it.polito.tdp.meteo.DAO;

import java.util.List;

import it.polito.tdp.meteo.model.Rilevamento;

public class TestMeteoDAO {

	public static void main(String[] args) {
		
		MeteoDAO dao = new MeteoDAO();

		List<Rilevamento> list = dao.getAllRilevamenti();
		for(Rilevamento t : list  )
	  System.out.println(t.toStringSS());
		
		  System.out.println("\n");
		for(String t : dao.AllLocalità()  )
	  System.out.println(t);
		

		  System.out.println("\n");
		List<Rilevamento> lists = dao.getAllRilevamentiLocalitaMese(1, "Genova");
		for(Rilevamento t : lists  )
	  System.out.println(t.toStringSS());
	
		 System.out.println("\n");
		 System.out.println("media : "+ dao.media(1,"Genova")+"\n");
		 
		 List<Rilevamento> list1 = dao.calcolaAvarage(1);
			for(Rilevamento t : list1  )
				  System.out.println(t.toStringSSMedia());
		

		// STAMPA: localita, giorno, mese, anno, umidita (%)
//		for (Rilevamento r : list) {
//			
//			System.out.format("%-10s %2td/%2$2tm/%2$4tY %3d%%\n", r.getLocalita(), r.getData(), r.getUmidita());
//			
//		}
//		
//		
//for (Rilevamento r : dao.getAllRilevamentiLocalitaMese(1, "Genova")) {
//			
//			System.out.format("%-10s %2td/%2$2tm/%2$4tY %3d%% si   \n", r.getLocalita(), r.getData(), r.getUmidita());
//			
//		}



		//System.out.print(dao.AllLocalità());
		

//		System.out.println(dao.getAllRilevamentiLocalitaMese(1, "Genova"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(1, "Genova"));
//		
//		System.out.println(dao.getAllRilevamentiLocalitaMese(5, "Milano"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(5, "Milano"));
//		
//		System.out.println(dao.getAllRilevamentiLocalitaMese(5, "Torino"));
//		System.out.println(dao.getAvgRilevamentiLocalitaMese(5, "Torino"));
		

	}

}
