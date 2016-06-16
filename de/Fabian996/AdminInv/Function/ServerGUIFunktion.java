package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ServerGUIFunktion implements Listener {
	

	public ServerGUIFunktion(AdminInv adminInv) {
	}

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Server Inventar")){
			e.setCancelled(true);
		
			if(e.getCurrentItem().getType() == Material.BARRIER){
				e.getView().close();
				Bukkit.broadcastMessage(AdminInv.AdminPrefix + "§4Der Server stopt");
				Bukkit.shutdown();
			}
			
			if(e.getCurrentItem().getType() == Material.STICK){
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
