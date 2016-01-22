package de.Fabian996.AdminInv.Function;

import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DifficultyFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Difficulty Inventory")){
			e.setCancelled(true);
					
			//Difficult <Peaceful/Easy/Normal/Hard> 
			if(e.getCurrentItem().getType() == Material.APPLE){
				p.getWorld().setDifficulty(Difficulty.PEACEFUL);
				p.sendMessage(Prefix + "§rDifficulty in world §e" + p.getLocation().getWorld().getName() + "§r set to §epeaceful");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.ARROW){
				p.getWorld().setDifficulty(Difficulty.EASY);
				p.sendMessage(Prefix + "§rDifficulty in world §6" + p.getLocation().getWorld().getName() + "§r set to §6Easy");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
				p.getWorld().setDifficulty(Difficulty.NORMAL);
				p.sendMessage(Prefix + "§rDifficulty in world §a" + p.getLocation().getWorld().getName() + "§r set to §aNormal");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.TNT){
				p.getWorld().setDifficulty(Difficulty.HARD);
				p.sendMessage(Prefix + "§rDifficulty in world §4" + p.getLocation().getWorld().getName() + "§r set to §4Hard");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
