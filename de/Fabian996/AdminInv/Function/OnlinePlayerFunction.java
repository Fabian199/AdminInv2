package de.Fabian996.AdminInv.Function;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnlinePlayerFunction implements Listener {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("unused")
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§7>> §0Online Players §7<<")){
			e.setCancelled(true);
		
		}
	}
}
