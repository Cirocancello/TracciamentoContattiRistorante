package it.TracciamentoContatti.db;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import it.TracciamentoContatti.model.Cliente;
import it.TracciamentoContatti.model.Prenotazione;
import it.TracciamentoContatti.model.Ristorante;
import it.TracciamentoContatti.model.Tavolo;

public class TracciaContattiDAO {
    
	/**
	 * Ricerca dei contatti in caso di contagio, nei tavoli adiacenti al contagiato
	 * e in quelli adiacenti a quest
	 * 
	 * @param cartaIdentita   carta di identità del contagiato
	 * @param data data della tavolata
	 * 
	 * @return ritorna il nome, cognome e telefono delle persone che hanno avuto
	 *         contatto con il contagiato
	 */
	public List<Cliente> tracciaContatti(String cartaIdentita, String data1) {

		String sql = "SELECT Cognome, Nome,Telefono " + "FROM clienti " + "WHERE CodiceTavolo IN "
				+ "(SELECT codiceTavolo FROM clienti " + "WHERE DATA = ? " + "AND codiceTavolo IN ( "
				+ "SELECT CodiceTavolo " + "FROM clienti " + "WHERE numeroCartaIdentita = ? " + "AND DATA = ? "
				+ "UNION " + "SELECT CodiceTavoloAdiacente " + "FROM tavoliadiacenti " + "WHERE CodiceTavolo IN "
				+ "(SELECT CodiceTavolo clienti " + "FROM clienti " + "WHERE numeroCartaIdentita = ? "
				+ "AND DATA = ? )) " + "UNION " + "SELECT codiceTavoloAdiacente " + "FROM tavoliadiacenti "
				+ "WHERE codiceTavolo IN (SELECT codiceTavolo FROM clienti " + "WHERE DATA = ? "
				+ "AND codiceTavolo IN ( " + "SELECT CodiceTavoloAdiacente " + "FROM tavoliadiacenti "
				+ "	WHERE CodiceTavolo IN " + "(SELECT CodiceTavolo " + "FROM clienti "
				+ "WHERE numeroCartaIdentita = ? " + "AND DATA = ?)))) ";
		
		
		List<Cliente> clientidaContattare = new ArrayList<>();
		Date data = Date.valueOf(data1);
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setDate(1, data);
			st.setDate(3, data);
			st.setDate(5, data);
			st.setDate(6, data);
			st.setDate(8, data);
			st.setString(2, cartaIdentita);
			st.setString(4, cartaIdentita);
			st.setString(7, cartaIdentita);

			ResultSet res = st.executeQuery();

			while (res.next()) {
				Cliente c = new Cliente(res.getString("Cognome"), res.getString("Nome"), res.getString("Telefono"));
				clientidaContattare.add(c);
			}
			res.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Database error in cerca tavoli liberi", e);
		}
		return clientidaContattare;
	}

}