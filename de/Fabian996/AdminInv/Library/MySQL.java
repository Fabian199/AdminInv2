package com.jimdo.Fabian996.AdminInv2.Library;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQL {
	
	private String host;
	private int port;
	private String user;
	private String password;
	private String database;
	private Connection con;
	private File f1 = new File("plugins/AdminInv2", "MySQL.yml");
	private FileConfiguration config = YamlConfiguration.loadConfiguration(this.f1);
	
	public MySQL() throws Exception{
		this.host = this.config.getString("AdminInv.MySQL.host");
		this.port = this.config.getInt("AdminInv.MySQL.port");
		this.user = this.config.getString("AdminInv.MySQL.user");
	    this.password = this.config.getString("AdminInv.MySQL.password");
	    this.database = this.config.getString("AdminInv.MySQL.database");
	    openConnection();
	}

	public Connection openConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.user, this.password);
		this.con = con;
		return con;
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public boolean hasConnection(){
		try{
			return(this.con != null) || (this.con.isValid(1));
		}catch(SQLException e){
		}
		return false;
	}
	
	public void closeRessources(ResultSet rs, PreparedStatement st){
		if (rs != null) {
			try{
				rs.close();
			}catch (SQLException localSQLException) {}
	    }
	    if (st != null) {
	    	try{
	    		rs.close();
	    	}catch (SQLException localSQLException1) {}
	    }
	}
	
	public void closeConnetion(){
		try{
			this.con.close();
	    }catch (SQLException ex){
	    	ex.printStackTrace();
	    }
	    	this.con = null;
	}
	  
	public void queryUpdate(String query){
		Connection con = this.con;
		PreparedStatement st = null;
		try{
			st = con.prepareStatement(query);
			st.executeUpdate();
		}catch (SQLException ex){
			System.err.println("Failed to send update '" + query + "'!");
		}
	}
}
