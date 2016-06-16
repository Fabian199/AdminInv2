package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class OnlinePlayerFunktion implements Listener {

	public OnlinePlayerFunktion(AdminInv adminInv) {
	}
	
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§7>> §0Online Players §7<<")){
			e.setCancelled(true);
		
		}
		
		if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
			e.getView().close();
			p.performCommand("admin");
		}
	}
}
