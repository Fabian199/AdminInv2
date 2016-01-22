package de.Fabian996.AdminInv.Function;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GamemodeFunction implements Listener {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§0Gamemode Inventory")){
			e.setCancelled(true);
			
			//Gamemode 0
			if(e.getCurrentItem().getType() ==  Material.BED){
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage((Prefix + "§7§l%p%§2 You play now in  §lSurvival Mode").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			//Gamemode 1
			if(e.getCurrentItem().getType() ==  Material.BEDROCK){
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage((Prefix + "§7§l%p%§6 You play now in  §lCreative Mode").replace("%p%",p.getName()));

				e.getView().close();
			}
			
			//Gamemode 2
			if(e.getCurrentItem().getType() ==  Material.STONE_SWORD){
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage((Prefix + "§7§l%p%§f You play now in §lAdventure Mode").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.BONE){
				p.setGameMode(GameMode.SPECTATOR);
				p.sendMessage((Prefix + "§7§l%p%§f You play now in §lSpectator Mode").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
