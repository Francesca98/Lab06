package it.polito.tdp.meteo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.polito.tdp.meteo.model.Rilevamento;

public class MeteoDAO {
	private  List<Rilevamento> result = new LinkedList<Rilevamento>();
	
	public List<Rilevamento> getAllRilevamenti() {

		final String sql = "SELECT Localita, Data, Umidita FROM situazione ORDER BY data ASC";

		List<Rilevamento> rilevamenti = new ArrayList<Rilevamento>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Rilevamento r = new Rilevamento(rs.getString("Localita"), rs.getDate("Data"), rs.getInt("Umidita"));
				rilevamenti.add(r);
			}

			conn.close();
			return rilevamenti;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Set<String> AllLocalità()
	{return getAllRilevamenti().stream().map(s->s.getLocalita()).collect(Collectors.toSet());}
		
	public  List<Rilevamento> calcolaAvarage(int mese) {
		
		for(String s : AllLocalità())
		{
			double media = media(mese, s);
		Rilevamento r = new Rilevamento(s, media);
		//System.out.println(r.getLocalita() + " media :" +r.getMedia() +"\n");

		this.result.add(r);
		}
		return result;
		
	}
	public double media(int mese,String loc)
	{
		double media =getAllRilevamentiLocalitaMese(mese, loc).stream().mapToDouble(t-> t.getUmidita()).average().
				getAsDouble();
		return media;
	}

	public List<Rilevamento> getAllRilevamentiLocalitaMese(int mese, String localita) {

		
		 List<Rilevamento> a = getAllRilevamenti().stream().filter(t->t.getLocalita().equals(localita)).
				 filter(t-> controlloData(mese, t.getData())).
		 collect(Collectors.toList());
		
		
		 return a;
		
	}
	
	public boolean controlloData(int mese,Date data)
	{
		if(data.getMonth()== mese-1)
		return true;
		return false;
	}


}
