package de.Fabian996.AdminInv.Function;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class AdminFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	//Config
	private File file = new File("plugins/AdminInv", "config.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Admin Inventory")){
			e.setCancelled(true);

			// Heal Function
			if(e.getCurrentItem().getType() == Material.POTION){
				p.setHealth(20);
				p.setFoodLevel(20);
				p.getActivePotionEffects().clear();
				p.sendMessage(Prefix + "&eYou were cured");
				e.getView().close();
			}
			
			//Fly Function
			if(e.getCurrentItem().getType() == Material.FEATHER){
	            if (p.getAllowFlight()) {
		              p.setFlying(false);
		              p.setAllowFlight(false);
		              p.sendMessage(Prefix + "&2Fly Disabled");
		            } else {
		              p.setAllowFlight(true);
		              p.setFlySpeed(0.1F);
		              p.sendMessage(Prefix + "&4Fly Enabled");		              
		            }
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.WATER_BUCKET){
				e.getView().close();
				p.performCommand("climate");
			}
			
			if(e.getCurrentItem().getType() == Material.PACKED_ICE){
				e.getView().close();
				p.performCommand("egms");
			}
			
			if(e.getCurrentItem().getType() == Material.CACTUS){
				e.getView().close();
				p.performCommand("diffis");
			}
			
			if(e.getCurrentItem().getType() == Material.SNOW_BLOCK){
					if(cfg.getBoolean("Inventory.ExtraInv", true)){
						e.getView().close();
						p.performCommand("extra");
					}else if(cfg.getBoolean("Inventory.ExtraInv", false)){
						e.getView().close();
						p.sendMessage(Prefix + "You can Enable in the Config");
					}		
			}

			if(e.getCurrentItem().getType() == Material.SPONGE){
				e.getView().close();
				p.performCommand("rl");
    			for( Player target : Bukkit.getOnlinePlayers()){
    				for(int i = 0; i < 80; i++){
    					target.sendMessage(" ");
    				}
    				target.sendMessage(Prefix + "§7Chat has been cleared");
    			}
			}
			
			if(e.getCurrentItem().getType() == Material.BOOK_AND_QUILL){
				e.getView().close();
				p.performCommand("areload");
			}
			
			if(e.getCurrentItem().getType() == Material.BARRIER){
				e.getView().close();
				p.performCommand("serverinv");
			}
			
			if(e.getCurrentItem().getType() == Material.SKULL_ITEM){
				e.getView().close();
				p.performCommand("onlinep");
			}
		}
	}
}
