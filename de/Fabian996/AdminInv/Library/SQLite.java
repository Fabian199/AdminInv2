package de.Fabian996.AdminInv.Library;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.bukkit.plugin.Plugin;

public class SQLite {

	private final String dbLocation;
	private Connection connection;
	
	Plugin plugin;
	
	public SQLite(Plugin plugin, String dbLocation){
	    this.dbLocation = dbLocation;
	    this.connection = null;
	}

	public Connection openConnection() {
		File file = new File(this.dbLocation);
		if (!file.exists())
	      try {
	        file.createNewFile();
	      } catch (IOException e) {
	        this.plugin.getLogger().log(Level.SEVERE, "Unable to create database!");
	      }
	    try{
	      Class.forName("org.sqlite.JDBC");
	      this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.plugin.getDataFolder().getPath().toString() + "/" + this.dbLocation);
	    } catch (SQLException e) {
	      this.plugin.getLogger().log(Level.SEVERE, "Could not connect to SQLite server! because: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	      this.plugin.getLogger().log(Level.SEVERE, "JDBC Driver not found!");
	    }
	    return this.connection;
	  }

	  public boolean checkConnection()
	  {
	    try {
	      return !this.connection.isClosed();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }return false;
	  }

	  public Connection getConnection()
	  {
	    return this.connection;
	  }

	  public void closeConnection()
	  {
	    if (this.connection != null)
	      try {
	        this.connection.close();
	      } catch (SQLException e) {
	        this.plugin.getLogger().log(Level.SEVERE, "Error closing the SQLite Connection!");
	        e.printStackTrace();
	      }
	  }
}
