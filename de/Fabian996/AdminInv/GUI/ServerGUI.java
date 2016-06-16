package com.jimdo.Fabian996.AdminInv2.GUI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ServerGUI implements CommandExecutor {
	
	public ServerGUI(AdminInv adminInv) {
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("serverinv")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
				AdminInv.Servers = p.getPlayer().getServer().createInventory(null, 18, "§0Server Inventar");
				// Inventar Erstellt...
				
				ItemStack Ja = new ItemStack(Material.BARRIER);
				ItemMeta Jameta = Ja.getItemMeta();
				Jameta.setDisplayName("§2Ja");
				Ja.setItemMeta(Jameta);
				
				ItemStack Nein = new ItemStack(Material.STICK);
				ItemMeta Neinmeta = Nein.getItemMeta();
				Neinmeta.setDisplayName("§4Nein");
				Nein.setItemMeta(Neinmeta);
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Zurück zum Inventar");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				AdminInv.Servers.setItem(2, Ja);
				AdminInv.Servers.setItem(6, Nein);
				
				AdminInv.Servers.setItem(9, Back);
				
				p.getPlayer().openInventory(AdminInv.Servers);
			}	
		}
		return true;
	}
}
