package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class DifficultyGUIFunktion implements Listener {

	public DifficultyGUIFunktion(AdminInv adminInv) {
	}

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§3Difficulty Inventar")){
			e.setCancelled(true);
;
			
			//Difficult <Peaceful/Easy/Normal/Hard> 
			if(e.getCurrentItem().getType() == Material.APPLE){
				p.getWorld().setDifficulty(Difficulty.PEACEFUL);
				p.sendMessage(AdminInv.AdminPrefix + "§eDifficulty in der Welt würde auf Peaceful gesetzt");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.ARROW){
				p.getWorld().setDifficulty(Difficulty.EASY);
				p.sendMessage(AdminInv.AdminPrefix + "§aDifficulty in der Welt würde auf Easy gesetzt");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.ENCHANTMENT_TABLE){
				p.getWorld().setDifficulty(Difficulty.NORMAL);
				p.sendMessage(AdminInv.AdminPrefix + "§7Difficulty in der Welt würde auf Normal gesetzt");
				e.getView().close();
			}
			if(e.getCurrentItem().getType() == Material.TNT){
				p.getWorld().setDifficulty(Difficulty.HARD);
				p.sendMessage(AdminInv.AdminPrefix + "§4Difficulty in der Welt würde auf Hard gesetzt");
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
