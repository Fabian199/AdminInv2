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

public class DiffiGUI implements CommandExecutor {
	
	
	public DiffiGUI(AdminInv adminInv) {
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("diffis")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
				AdminInv.Diffi = p.getPlayer().getServer().createInventory(null, 18, "§3Difficulty Inventar");
				// Inventar Erstellt...
				
				// Icons im Inventar festlegen..
				
				ItemStack Peace = new ItemStack(Material.APPLE);
				ItemMeta PeaceMe = Peace.getItemMeta();
				PeaceMe.setDisplayName("§ePeaceful");
				Peace.setItemMeta(PeaceMe);
				
				ItemStack Easy = new ItemStack(Material.ARROW);
				ItemMeta EasyMe = Easy.getItemMeta();
				EasyMe.setDisplayName("§2Easy");
				Easy.setItemMeta(EasyMe);
				
				ItemStack Normal = new ItemStack(Material.ENCHANTMENT_TABLE);
				ItemMeta NormalMe = Normal.getItemMeta();
				NormalMe.setDisplayName("§5Normal");
				Normal.setItemMeta(NormalMe);
				
				ItemStack Hard = new ItemStack(Material.TNT);
				ItemMeta HardMe = Hard.getItemMeta();
				HardMe.setDisplayName("§4Hard");
				Hard.setItemMeta(HardMe);
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Zurück zum Inventar");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				AdminInv.Diffi.setItem(2, Peace);
				AdminInv.Diffi.setItem(3, Easy);
				AdminInv.Diffi.setItem(4, Normal);
				AdminInv.Diffi.setItem(5, Hard);
				
				AdminInv.Diffi.setItem(9, Back);
				
				p.getPlayer().openInventory(AdminInv.Diffi);
				}
		}
		return true;
	}
}
