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

public class WeatherInv implements CommandExecutor {
		
	public Inventory Wetter = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("climate")){
			if(p.hasPermission("AdminInv.Wetter")){
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_DEATH, 100.0F, 60.0F);
				Wetter = p.getPlayer().getServer().createInventory(null, 18, "§0Weather Inventory");

				ItemStack Storm = new ItemStack(Material.WATER_LILY);
				ItemMeta Stormmeta = Storm.getItemMeta();
				ArrayList<String> StormM = new ArrayList<String>();
				Stormmeta.setDisplayName("§bStorm");
				StormM.add("§fIt catches in to rain in the world ");
				Stormmeta.setLore(StormM);
				Storm.setItemMeta(Stormmeta);
				
				ItemStack Clear = new ItemStack(Material.SAND);
				ItemMeta Clearmeta = Clear.getItemMeta();
				ArrayList<String> ClearM = new ArrayList<String>();
				Clearmeta.setDisplayName("§7Clear");
				ClearM.add("§fThe weather we again normally ");
				Clearmeta.setLore(ClearM);
				Clear.setItemMeta(Clearmeta);
				
				ItemStack Thundering = new ItemStack(Material.BLAZE_ROD);
				ItemMeta Thunderingmeta = Thundering.getItemMeta();
				ArrayList<String> ThunderingM = new ArrayList<String>();
				Thunderingmeta.setDisplayName("§5Thundering");
				ThunderingM.add("§fIt starts to thunderstorms in the world ");
				Thunderingmeta.setLore(ThunderingM);
				Thundering.setItemMeta(Thunderingmeta);
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				Wetter.setItem(3, Storm);
				Wetter.setItem(4, Clear);
				Wetter.setItem(5, Thundering);
				
				Wetter.setItem(9, Back);
				
				p.getPlayer().openInventory(Wetter);
				}
		}
		return true;
	}
}
