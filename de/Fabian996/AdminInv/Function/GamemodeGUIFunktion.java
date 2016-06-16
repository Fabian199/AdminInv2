package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class GamemodeGUIFunktion implements Listener {
	
	public GamemodeGUIFunktion(AdminInv adminInv) {
	}
	
	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§6Gamemode Inventar")){
			e.setCancelled(true);
			
			//Gamemode 0
			if(e.getCurrentItem().getType() ==  Material.BED){
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage((AdminInv.AdminPrefix + "§7§l%p%§2 Du spielst nun im §lSurvival Modus").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			//Gamemode 1
			if(e.getCurrentItem().getType() ==  Material.BEDROCK){
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage((AdminInv.AdminPrefix + "§7§l%p%§6 Du spielst nun im §lCreative Modus").replace("%p%",p.getName()));

				e.getView().close();
			}
			
			//Gamemode 2
			if(e.getCurrentItem().getType() ==  Material.STONE_SWORD){
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage((AdminInv.AdminPrefix + "§7§l%p%§f Du spielst nun im §lAdventure Modus").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.BONE){
				p.setGameMode(GameMode.SPECTATOR);
				p.sendMessage((AdminInv.AdminPrefix + "§7§l%p%§f Du spielst nun im §lSpectator Modus").replace("%p%",p.getName()));
				
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.GOLD_NUGGET){
				e.getView().close();
				p.performCommand("admin");
			}
		}
	}
}
