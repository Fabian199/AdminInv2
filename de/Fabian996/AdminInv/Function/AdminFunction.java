package de.Fabian996.AdminInv.Function;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("unused")
	private ArrayList<Player> vanished = new ArrayList<>();

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Admin Inventory")){
			e.setCancelled(true);
		
			// Heal Function
			if(e.getCurrentItem().getType() == Material.POTION){
				p.setHealth(20);
				p.setFoodLevel(20);
				p.sendMessage(Prefix + "§3You were cured");
				e.getView().close();
			}
			
			//Fly Function
			if(e.getCurrentItem().getType() == Material.FEATHER){
	            if (p.getAllowFlight()) {
		              p.setFlying(false);
		              p.setAllowFlight(false);
		              p.sendMessage(Prefix + "§cFly disabled");
		            } else {
		              p.setAllowFlight(true);
		              p.setFlySpeed(0.1F);
		              p.sendMessage(Prefix + "§2Fly Enabled");		              
		            }
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.WATER_BUCKET){
				e.getView().close();
				p.performCommand("climate");
			}
			
			if(e.getCurrentItem().getType() == Material.PACKED_ICE){
				e.getView().close();
				p.performCommand("egm");
			}
			
			if(e.getCurrentItem().getType() == Material.CACTUS){
				e.getView().close();
				p.performCommand("diffis");
			}
		}
	}
}
