package com.jimdo.Fabian996.AdminInv2.Events;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class PlayerCommandPreprocessEvents implements Listener {

	AdminInv p;
	
	public PlayerCommandPreprocessEvents(AdminInv adminInv) {
		this.p = adminInv;
	}
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e){
	    if (!AdminInv.instance.getConfig().getBoolean("Einstellung.Command_Log")) {
	      return;
	    }
	    Player p = e.getPlayer();
	    Date d = Calendar.getInstance().getTime();
	    DateFormat tm = new SimpleDateFormat("dd-MM-yyyy");
	    String date = tm.format(d);
	    Date d1 = Calendar.getInstance().getTime();
	    DateFormat tm1 = new SimpleDateFormat("HH:mm:ss");
	    String time = tm1.format(d1);
	    File f = new File("plugins/AdminInv2/Commands", date.replace(":", "_") + ".yml");
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
	    List<String> commands = config.getStringList("Commands");
	    commands.add(time.toString() + " - " + p.getName() + " : " + e.getMessage());
	    config.set("Commands", commands);
	    saveConfig(config, f);
	}
	
	public void saveConfig(YamlConfiguration config, File file){
		try{
			config.save(file);
	    }catch (IOException ex){
		   	ex.printStackTrace();
	    }
	}
}
