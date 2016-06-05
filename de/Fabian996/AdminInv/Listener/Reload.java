package com.jimdo.Fabian996.AdminInv2.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Reload implements Listener {
	
	@EventHandler
	public void Reload(PlayerCommandPreprocessEvent e){
	    Player p = e.getPlayer();
	    String command = e.getMessage();
	    if (((command.equalsIgnoreCase("/rl")) || (command.equalsIgnoreCase("/reload"))) && (p.hasPermission("admininv.reload"))){
	      Bukkit.broadcastMessage(AdminInv.SystemPrefix + "§c --| SERVER RELOAD |--");
	      Bukkit.broadcastMessage(AdminInv.SystemPrefix + "§cBitte nicht bewegen, schreiben oder etwas abbauen!");
	      Bukkit.broadcastMessage(""); 
	      Bukkit.reload();
	      Bukkit.broadcastMessage("");
	      Bukkit.broadcastMessage(AdminInv.SystemPrefix + "§a --| RELOAD ERFOLGREICH |--");
	      Bukkit.broadcastMessage(AdminInv.SystemPrefix + "§aDu kannst nun wieder alles machen)");
	      e.setCancelled(true);
	    }
	}
}
