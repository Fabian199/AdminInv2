package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class AdminGUIFunktion implements Listener{

	AdminInv p;
	
	public AdminGUIFunktion(AdminInv adminInv) {
		this.p = adminInv;
	}

	@EventHandler
	public void Inventory(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§4Admin GUI")){
			e.setCancelled(true);

			// Heal Function
			if(e.getCurrentItem().getType() == Material.POTION){
				p.setHealth(20);
				p.setFoodLevel(20);
				p.getActivePotionEffects().clear();
				p.sendMessage(AdminInv.AdminPrefix + "§7Du würdst geheilt");
				e.getView().close();
			}
			
			//Fly Function
			if(e.getCurrentItem().getType() == Material.FEATHER){
	            if (p.getAllowFlight()) {
		              p.setFlying(false);
		              p.setAllowFlight(false);
		              p.sendMessage(AdminInv.AdminPrefix + "§cFly Disabled");
		            } else {
		              p.setAllowFlight(true);
		              p.setFlySpeed(0.1F);
		              p.sendMessage(AdminInv.AdminPrefix + "§aFly Enabled");		              
		            }
				e.getView().close();
			}
			
			if(e.getCurrentItem().getType() == Material.WATER_BUCKET){
				e.getView().close();
				p.performCommand("climate");
			}
			
			if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
				e.getView().close();
				p.performCommand("gamem");
			}
			
			if(e.getCurrentItem().getType() == Material.CACTUS){
				e.getView().close();
				p.performCommand("diffis");
			}
			
			if(e.getCurrentItem().getType() == Material.SLIME_BALL){
				e.getView().close();
				p.performCommand("v");
			}
			
			if(e.getCurrentItem().getType() == Material.SNOW_BLOCK){
					if(AdminInv.cfg.getBoolean("Inventory.ExtraInv", true)){
						e.getView().close();
						p.performCommand("extra");
					}else if(AdminInv.cfg.getBoolean("Inventory.ExtraInv", false)){
						e.getView().close();
						p.sendMessage(AdminInv.AdminPrefix + "§7Du kannst es in der Config Aktivieren");
					}		
			}

			if(e.getCurrentItem().getType() == Material.SPONGE){
				e.getView().close();
				p.performCommand("reload");
    			for( Player target : Bukkit.getOnlinePlayers()){
    				for(int i = 0; i < 100; i++){
    					target.sendMessage(" ");
    				}
    				target.sendMessage(AdminInv.AdminPrefix + "§7Der Chat würde gelöscht");
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
			//	p.performCommand("onlinep");
			}
		}
	}
}
