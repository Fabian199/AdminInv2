package com.jimdo.Fabian996.AdminInv2.Library;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigGenerator {

	
	public static void CreateConfigs(){
	    File mysqlfile = new File("plugins/AdminInv2/Einstellung", "MySQL.yml");
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
		
		File scoreboardfile = new File("plugins/AdminInv2/Einstellung", "Scoreboard.yml");
		YamlConfiguration scoreboardcfg = YamlConfiguration.loadConfiguration(scoreboardfile);
		
		scoreboardcfg.addDefault("Scoreboard.Title", "&8-= &6&lYOUR SERVER  &8=-");
		scoreboardcfg.addDefault("Scoreboard.Line1", "&2&lModus:");
		scoreboardcfg.addDefault("Scoreboard.Line2", "&8- &7Example: SurvivalGames");
		scoreboardcfg.addDefault("Scoreboard.Placeholder1", "&7");
		scoreboardcfg.addDefault("Scoreboard.Line3", "&2&lTeamspeak");
		scoreboardcfg.addDefault("Scoreboard.Line4", "&8- &7Teamspeak I");
		scoreboardcfg.addDefault("Scoreboard.Line5", "&7&m------------------------");
		scoreboardcfg.options().copyDefaults(true);
		saveConfig(scoreboardcfg, scoreboardfile);
	}
	
	 public static void saveConfig(YamlConfiguration config, File file){
		 try{
			 config.save(file);
		 }catch (IOException ex){
			 ex.printStackTrace();
	  	 }
	 }

	public static void loadConfig() {
	    File mysqlfile = new File("plugins/AdminInv2/Einstellung", "MySQL.yml");
	    FileConfiguration mysqlcfg = YamlConfiguration.loadConfiguration(mysqlfile);
		
		File banfile = new File("plugins/AdminInv2", "banlist.yml");
		FileConfiguration bancfg = YamlConfiguration.loadConfiguration(banfile);
		
		File scoreboardfile = new File("plugins/AdminInv2/Einstellung", "Scoreboard.yml");
		FileConfiguration scoreboardcfg = YamlConfiguration.loadConfiguration(scoreboardfile);
		
		try {
			mysqlcfg.load(mysqlfile);
			bancfg.load(banfile);
			scoreboardcfg.load(scoreboardfile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
}
