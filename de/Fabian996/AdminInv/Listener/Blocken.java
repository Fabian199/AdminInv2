package com.jimdo.Fabian996.AdminInv2.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Block implements Listener{
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onUnknow(PlayerCommandPreprocessEvent e){
		if(!(e.isCancelled())){
			Player p = (Player)e.getPlayer();
			String msg = e.getMessage().split(" ") [0];
			HelpTopic help = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if (help == null){
				p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BREAK, 2F, 1F);
				p.sendMessage(AdminInv.AdminPrefix + "§8[ §b§l! §8] §cFalscher Befehl");
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlugin(PlayerCommandPreprocessEvent e){
		String args[] = e.getMessage().split(" ");
		if((args[0].equalsIgnoreCase("/pl")) || (args[0].equalsIgnoreCase("/plugins")) || (args[0].equalsIgnoreCase("/?")) || (args[0].equalsIgnoreCase("/help"))){
			Player p = e.getPlayer();
			if(p.isOp()){
				
			}else{
				e.setCancelled(true);
				p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 1.5F, -1F);
				p.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
			}
		}	
	}

}
