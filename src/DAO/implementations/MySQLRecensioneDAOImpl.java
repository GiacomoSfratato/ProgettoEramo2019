package DAO.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.*;
import DAO.MySQLDAOFactory;
import DAO.interfaces.RecensioneDAO;

public class MySQLRecensioneDAOImpl implements RecensioneDAO {

	 	private static final String elenco_recensioni = "CALL elenco_recensioni?()";
	    private static final String elenco_recensioni_attesa = "CALL elenco_recensioni_attesa()";
	    private static final String	inserimento_recensione = "CALL inserimento_recensione(";
	    private static final String rimuovere_recensione = "call inserimento_utente(?,?,?,?,?,?,?,?)";
	    private static final String verifica_recensione = "call rimuovere_utente(?,?)";
	
}
