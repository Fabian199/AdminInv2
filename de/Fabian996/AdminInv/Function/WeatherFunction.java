package de.Fabian996.AdminInv.Function;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WeatherFunction implements Listener {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";

	@SuppressWarnings("unused")
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Weather Inventory")){
			e.setCancelled(true);
		
			// Weather Function
			if(e.getCurrentItem().getType() == Material.WATER_LILY){
				World world = p.getWorld();
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(false);
				p.sendMessage(Prefix + "§3It starts raining ");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.SAND){
				World world = p.getWorld();
				p.getWorld().setStorm(false);
				p.getWorld().setThundering(false);
				p.sendMessage(Prefix + "§3Now the weather stops ");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.BLAZE_ROD){
				World world = p.getWorld();
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(true);
				p.sendMessage(Prefix + "§3It starts to thunderstorms ");
				e.getView().close();
			}
			
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
