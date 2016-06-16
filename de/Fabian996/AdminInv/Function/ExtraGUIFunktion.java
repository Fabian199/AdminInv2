package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ExtraGUIFunktion implements Listener {

	public ExtraGUIFunktion (AdminInv adminInv) {
	
	}

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§5Extra Inventar")){
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
					if(!(p.hasPermission("admininv.ignore") || (!p.hasPermission("admininv.*"))));
					target.kickPlayer("Du würdst vom der Console gekickt");	
				}
			}
			
			if(e.getCurrentItem().getType() == Material.SUGAR){
				e.getView().close();
				String message = "Der Spieler §6" + p.getName() + " §rHat die Welt gespeichert" ;
				Bukkit.broadcastMessage(AdminInv.AdminPrefix + message);
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "save-all");
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
