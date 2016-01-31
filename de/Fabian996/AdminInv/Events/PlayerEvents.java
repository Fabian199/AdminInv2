package de.Fabian996.AdminInv.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class PlayerEvents implements Listener {
	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoinServer(PlayerLoginEvent e){
		Player p = e.getPlayer();
		TitleAPI.sendTitle(p, 25, 20, 25, "§6Willkommen auf den Server ");
		TitleAPI.sendSubtitle(p, 25, 20, 25, "§2" + p.getName());
		
	}
}
