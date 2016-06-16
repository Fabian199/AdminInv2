package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class WeatherGUIFFunktion implements Listener {
	

	@SuppressWarnings("unused")
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§2Wetter/Zeit Inventar")){
			e.setCancelled(true);
		
			// Weather Function
			if(e.getCurrentItem().getType() == Material.WATER_LILY){
				World world = p.getWorld();
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(false);
				p.sendMessage(AdminInv.AdminPrefix + "§3Es fängt an zu Regnen");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.SAND){
				World world = p.getWorld();
				p.getWorld().setStorm(false);
				p.getWorld().setThundering(false);
				p.sendMessage(AdminInv.AdminPrefix  + "§3Das Wetter hört auf ");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.BLAZE_ROD){
				World world = p.getWorld();
				p.getWorld().setStorm(true);
				p.getWorld().setThundering(true);
				p.sendMessage(AdminInv.AdminPrefix  + "§3Es fängt an zu Gewittern");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.DAYLIGHT_DETECTOR){
				World world = p.getWorld();
				p.getWorld().setTime(0);
				p.sendMessage(AdminInv.AdminPrefix  + "In der Welt §6" + world.getName() + " §fist nun Tag");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.SOUL_SAND){
				World world = p.getWorld();
				p.getWorld().setTime(13000);
				p.sendMessage(AdminInv.AdminPrefix  + "In der Welt §6" + world.getName() + " §fist nun Nacht");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
