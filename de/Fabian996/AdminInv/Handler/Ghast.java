package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class GUIItemFunktion implements Listener{

	AdminInv p;
	
	public GUIItemFunktion(AdminInv adminInv) {
		this.p = adminInv;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChestClick(PlayerInteractEvent e){
		if((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			if(e.getPlayer().getItemInHand().getType() == Material.GHAST_TEAR){
				Player p = e.getPlayer();
				Bukkit.dispatchCommand(p.getPlayer(), "admin");	
			}
		}
	}
}
