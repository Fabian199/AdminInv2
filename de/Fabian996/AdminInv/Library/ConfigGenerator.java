package com.jimdo.Fabian996.AdminInv2.Library;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ConfigGenerator {

	AdminInv pl;
	
	public ConfigGenerator(AdminInv main){
		this.pl = main;
	}
	
	public static void CreateConfigs(){
	    File mysqlfile = new File("plugins/AdminInv2", "MySQL.yml");
	    YamlConfiguration mysqlcfg = YamlConfiguration.loadConfiguration(mysqlfile);
	    
	    mysqlcfg.addDefault("AdminInv.MySQL.Enabled", Boolean.valueOf(false));
	    mysqlcfg.addDefault("AdminInv.MySQL.host", "localhost");
	    mysqlcfg.addDefault("AdminInv.MySQL.port", Integer.valueOf(3306));
	    mysqlcfg.addDefault("AdminInv.MySQL.user", "user");
	    mysqlcfg.addDefault("AdminInv.MySQL.password", "password");
	    mysqlcfg.addDefault("AdminInv.MySQL.database", "database");
	    mysqlcfg.options().copyDefaults(true);
	    saveConfig(mysqlcfg, mysqlfile);
	    
	    File banfile = new File("plugins/AdminInv2", "banlist.yml");
		YamlConfiguration bancfg = YamlConfiguration.loadConfiguration(banfile);
		
		bancfg.addDefault("Ban", null);
		bancfg.options().copyDefaults(true);
		saveConfig(bancfg, banfile);
	    
	}
	
	 public static void saveConfig(YamlConfiguration config, File file){
		 try{
			 config.save(file);
		 }catch (IOException ex){
			 ex.printStackTrace();
	  	 }
	 }
}
