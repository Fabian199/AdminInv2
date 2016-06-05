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
import org.bukkit.event.player.PlayerChatEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

@SuppressWarnings("deprecation")
public class PlayerChatEvents implements Listener {
	
	AdminInv p;
	
	public PlayerChatEvents(AdminInv adminInv) {
		this.p = adminInv;
	}
	
	@EventHandler
	public void onPlayerChatEvent(PlayerChatEvent e){
	    if(!AdminInv.instance.getConfig().getBoolean("Einstellung.Chat_Log")){
	       return;
	    }
	    Player p = e.getPlayer();
	    Date d = Calendar.getInstance().getTime();
	    DateFormat tm = new SimpleDateFormat("dd-MM-yyyy");
	    String date = tm.format(d);
	    Date d1 = Calendar.getInstance().getTime();
	    DateFormat tm1 = new SimpleDateFormat("HH:mm:ss");
	    String time = tm1.format(d1);
	    File f = new File("plugins/AdminInv2/Chat", date.replace(":", "_") + ".yml");
	    YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
	    List<String> chat = config.getStringList("Chat");
	    chat.add(time.toString() + " - " + p.getName() + " : " + e.getMessage());
	    config.set("Chat", chat);
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
