package de.Fabian996.AdminInv.Function;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ExtraFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Extra Inventory")){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getType() == Material.BUCKET){
				e.getView().close();
				p.performCommand("cc");
			}
			
			if(e.getCurrentItem().getType() == Material.DRAGON_EGG){
				e.getView().close();
				p.performCommand("sinfo");
			}
			
			if(e.getCurrentItem().getType() == Material.PAPER){
				e.getView().close();
				p.performCommand("vote");
			}
			
			if(e.getCurrentItem().getType() == Material.ROTTEN_FLESH){
				e.getView().close();
				for(Player target : Bukkit.getServer().getOnlinePlayers()){
					if(p.hasPermission("AdminInv.Ignore"));
					target.kickPlayer("You was kick form Admin");	
				}
			}
			
			if(e.getCurrentItem().getType() == Material.SUGAR){
				e.getView().close();
				String message = "The Player §6" + p.getName() + " §rhas save the Worlds" ;
				Bukkit.broadcastMessage(Prefix + message);
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "save-all");
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
