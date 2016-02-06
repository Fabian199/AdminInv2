package de.Fabian996.AdminInv.Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class MySQL extends Database{
	private String hostname = "localhost";
	private String portnmbr = "3306";
	private String username = "minecraft";
	private String password = "";
	private String database = "minecraft";

	public MySQL(Logger log, String prefix, String hostname, String portnmbr, String database, String username, String password) {
		super(log, prefix, "[MySQL] ");
		this.hostname = hostname;
		this.portnmbr = portnmbr;
		this.database = database;
		this.username = username;
		this.password = password;
	 }

	protected boolean initialize(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return true;
		} catch (ClassNotFoundException e) {
			writeError("Class Not Found Exception: " + e.getMessage() + ".", true);
		}return false;
	}
	
	public Connection open(){
		if (initialize()) {
			String url = "";
			try {
				url = "jdbc:mysql://" + this.hostname + ":" + this.portnmbr + "/" + this.database;
				return DriverManager.getConnection(url, this.username, this.password);
			} catch (SQLException e) {
				writeError(url, true);
				writeError("Could not be resolved because of an SQL Exception: " + e.getMessage() + ".", true);
			}
		}
		return null;
	}

	public void close(){
		Connection connection = open();
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			writeError("Failed to close database connection: " + e.getMessage(), true);
		}
	}

	public Connection getConnection(){
		return open();
	}

	public boolean checkConnection(){
		Connection connection = open();

		return connection != null;
	}

	public ResultSet query(String query){
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		try {
			connection = open();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT CURTIME()");

			switch ($SWITCH_TABLE$lib$PatPeter$SQLibrary$DatabaseHandler$Statements()[getStatement(query).ordinal()]) {
			case 1:
				result = statement.executeQuery(query);
				return result;
			}

			statement.executeUpdate(query);
			return result;
		}
		catch (SQLException e) {
			writeError("Error in SQL query: " + e.getMessage(), false);
		}
		return result;
	}

	private int[] $SWITCH_TABLE$lib$PatPeter$SQLibrary$DatabaseHandler$Statements() {
		return null;
	}

	public PreparedStatement prepare(String query){
		Connection connection = null;
		PreparedStatement ps = null;
		try{
			connection = open();
			ps = connection.prepareStatement(query);
			return ps;
		} catch (SQLException e) {
			if (!e.toString().contains("not return ResultSet"))
				writeError("Error in SQL prepare() query: " + e.getMessage(), false);
		}
		return ps;
	}

	public boolean createTable(String query){
		Statement statement = null;
		try {
			this.connection = open();
			if ((query.equals("")) || (query == null)) {
				writeError("SQL query empty: createTable(" + query + ")", true);
				return false;
			}

			statement = this.connection.createStatement();
			statement.execute(query);
  	   return true;
		} catch (SQLException e) {
			writeError(e.getMessage(), true);
			return false;
  	 } catch (Exception e) {
  		 writeError(e.getMessage(), true);
  	 }return false;
	}

	public boolean checkTable(String table){
		try{
			Connection connection = open();

			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery("SELECT * FROM " + table);

    	 return result != null;
		}catch (SQLException e){
			if (e.getMessage().contains("exist")) {
				return false;
			}
			writeError("Error in SQL query: " + e.getMessage(), false);

			if (query("SELECT * FROM " + table) == null) return true; 
		}
		return false;
	}

	public boolean wipeTable(String table){
		Statement statement = null;
		String query = null;
		try {
			if (!checkTable(table)) {
				writeError("Error wiping table: \"" + table + "\" does not exist.", true);
				return false;
			}

			this.connection = open();
			statement = this.connection.createStatement();
			query = "DELETE FROM " + table + ";";
			statement.executeUpdate(query);

			return true;
		} catch (SQLException e) {
			if (!e.toString().contains("not return ResultSet"))
				return false;
			}
		return false;
		}
	}
