package de.Fabian996.AdminInv.GUI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DiffiInv implements CommandExecutor {
	
	public Inventory Diffi = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("diffis")){
			if(p.hasPermission("AdminInv.Diffi")){
				p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1000.0F, 6.0F);
				Diffi = p.getPlayer().getServer().createInventory(null, 18, "§0Difficulty Inventory");
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
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				Diffi.setItem(2, Peace);
				Diffi.setItem(3, Easy);
				Diffi.setItem(4, Normal);
				Diffi.setItem(5, Hard);
				
				Diffi.setItem(9, Back);
				
				p.getPlayer().openInventory(Diffi);
				}
		}
		return true;
	}
}
