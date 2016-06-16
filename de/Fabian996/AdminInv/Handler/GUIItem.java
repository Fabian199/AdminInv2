package com.jimdo.Fabian996.AdminInv2.Funktion;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class GUIItem implements CommandExecutor{

	AdminInv p;
	
	public GUIItem(AdminInv adminInv) {
		this.p = adminInv;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("ghast")){
			ItemStack Ghast = new ItemStack(Material.GHAST_TEAR);
			ItemMeta Ghastmeta = Ghast.getItemMeta();
			Ghastmeta.setDisplayName("§cAdmin GUI");
			Ghast.setItemMeta(Ghastmeta);
				if(p.isOp() || p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
					p.getInventory().setItem(0, Ghast);
					p.sendMessage(AdminInv.AdminPrefix + "§7Du hast das Admin-Inventar Item erhalten");
			}
		}
		return false;
	}
}
