package com.jimdo.Fabian996.AdminInv2.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class OnlinePlayerGUI implements CommandExecutor {
	
	public OnlinePlayerGUI(AdminInv adminInv) {
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("onlinep")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
				AdminInv.OnleinPlayer = p.getPlayer().getServer().createInventory(null, 54, "§7>> §0Online Players §7<<");

				ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
				ItemMeta Glassmeta = Glass.getItemMeta();
				Glassmeta.setDisplayName("*");
				Glass.setItemMeta(Glassmeta);
				
				ItemStack Comming = new ItemStack(Material.NETHER_STAR);
				ItemMeta Commingmeta = Comming.getItemMeta();
				Commingmeta.setDisplayName("§5Kommt Bald");
				Comming.setItemMeta(Commingmeta);
				
				ItemStack Right = new ItemStack(Material.SKULL_ITEM,1 ,(short) 3);
				SkullMeta Rightmeta = (SkullMeta)Right.getItemMeta();
				Rightmeta.setOwner("MHF_ArrowRight");
				Rightmeta.setDisplayName("§3Next");
				Right.setItemMeta(Rightmeta);
				
				for(Player onlineplayers : Bukkit.getOnlinePlayers()){
					if(onlineplayers != p.getPlayer()){
						ItemStack Skull = new ItemStack(Material.SKULL_ITEM,1 ,(short) 3);
						SkullMeta Skullmeta = (SkullMeta) Skull.getItemMeta();
						Skullmeta.setDisplayName(onlineplayers.getName());
						Skullmeta.setOwner(onlineplayers.getDisplayName());
						Skull.setItemMeta(Skullmeta);
						
						AdminInv.OnleinPlayer.addItem(Skull);
					}
				}
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Zurück zum Inventar");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);
				
				AdminInv.OnleinPlayer.setItem(45, Back);
				AdminInv.OnleinPlayer.setItem(46, Glass);
				AdminInv.OnleinPlayer.setItem(47, Glass);
				AdminInv.OnleinPlayer.setItem(48, Glass);
				AdminInv.OnleinPlayer.setItem(49, Comming);
				AdminInv.OnleinPlayer.setItem(50, Glass);
				AdminInv.OnleinPlayer.setItem(51, Glass);
				AdminInv.OnleinPlayer.setItem(52, Glass);
				AdminInv.OnleinPlayer.setItem(53, Right);
				
						
				p.getPlayer().openInventory(AdminInv.OnleinPlayer);
			}
		}		
		return true;
	}
}
