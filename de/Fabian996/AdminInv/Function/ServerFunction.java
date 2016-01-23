package de.Fabian996.AdminInv.Function;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ServerFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Server Inventory")){
			e.setCancelled(true);
		
			if(e.getCurrentItem().getType() == Material.BARRIER){
				e.getView().close();
				Bukkit.broadcastMessage(Prefix + "§4The Server stopt");
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
