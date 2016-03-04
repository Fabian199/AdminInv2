package de.Fabian996.AdminInv.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.Fabian996.AdminInv.Main.AdminMain;

public class OnlinePlayerInv implements CommandExecutor {

	@SuppressWarnings("unused")
	private static AdminMain instance;

	public Inventory OnlinePlayer = null;

	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("onlinep")){
			if(p.hasPermission("AdminInv.Admin") || p.hasPermission("AdminInv.*")){
				OnlinePlayer = p.getPlayer().getServer().createInventory(null, 54, "§7>> §0Online Players §7<<");

				ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
				ItemMeta Glassmeta = Glass.getItemMeta();
				Glassmeta.setDisplayName("*");
				Glass.setItemMeta(Glassmeta);
				
				ItemStack Comming = new ItemStack(Material.NETHER_STAR);
				ItemMeta Commingmeta = Comming.getItemMeta();
				Commingmeta.setDisplayName("§5Comming Soon");
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
						
						OnlinePlayer.addItem(Skull);
					}
				}
				OnlinePlayer.setItem(45, Glass);
				OnlinePlayer.setItem(46, Glass);
				OnlinePlayer.setItem(47, Glass);
				OnlinePlayer.setItem(48, Glass);
				OnlinePlayer.setItem(49, Comming);
				OnlinePlayer.setItem(50, Glass);
				OnlinePlayer.setItem(51, Glass);
				OnlinePlayer.setItem(52, Glass);
				OnlinePlayer.setItem(53, Right);
				
						
				p.getPlayer().openInventory(OnlinePlayer);
			}
		}		
		return true;
	}
}
