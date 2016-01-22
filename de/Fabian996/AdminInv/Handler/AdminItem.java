package de.Fabian996.AdminInv.Handler;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminItem implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("ghast")){
			ItemStack Ghast = new ItemStack(Material.GHAST_TEAR);
			ItemMeta Ghastmeta = Ghast.getItemMeta();
			Ghastmeta.setDisplayName("§4Admin Inventory");
			Ghast.setItemMeta(Ghastmeta);
				if(p.isOp() || p.hasPermission("AdminInv.AdminItem")){

					p.getInventory().setItem(0, Ghast);
					p.sendMessage(Prefix + "You have become Admin GUI Item");
			}
		}
		return false;
	}
}
