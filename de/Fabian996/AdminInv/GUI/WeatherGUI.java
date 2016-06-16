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

public class WeatherGUI implements CommandExecutor {
	
	public WeatherGUI(AdminInv adminInv) {
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("climate")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
				AdminInv.Wetter = p.getPlayer().getServer().createInventory(null, 18, "§2Wetter/Zeit Inventar");

				ItemStack Storm = new ItemStack(Material.WATER_LILY);
				ItemMeta Stormmeta = Storm.getItemMeta();
				ArrayList<String> StormM = new ArrayList<String>();
				Stormmeta.setDisplayName("§bStorm");
				StormM.add("§fEs fängt an zu Storm");
				Stormmeta.setLore(StormM);
				Storm.setItemMeta(Stormmeta);
				
				ItemStack Clear = new ItemStack(Material.SAND);
				ItemMeta Clearmeta = Clear.getItemMeta();
				ArrayList<String> ClearM = new ArrayList<String>();
				Clearmeta.setDisplayName("§7Clear");
				ClearM.add("§7Das Wetter verschwindet");
				Clearmeta.setLore(ClearM);
				Clear.setItemMeta(Clearmeta);
				
				ItemStack Thundering = new ItemStack(Material.BLAZE_ROD);
				ItemMeta Thunderingmeta = Thundering.getItemMeta();
				ArrayList<String> ThunderingM = new ArrayList<String>();
				Thunderingmeta.setDisplayName("§5Thundering");
				ThunderingM.add("§fEs fängt an zu Gewittern");
				Thunderingmeta.setLore(ThunderingM);
				Thundering.setItemMeta(Thunderingmeta);
				
				ItemStack Day = new ItemStack(Material.DAYLIGHT_DETECTOR);
				ItemMeta Daymeta = Day.getItemMeta();
				Daymeta.setDisplayName("§eDay");
				Day.setItemMeta(Daymeta);
				
				ItemStack Night = new ItemStack(Material.SOUL_SAND);
				ItemMeta Nightmeta = Night.getItemMeta();
				Nightmeta.setDisplayName("§1Night");
				Night.setItemMeta(Nightmeta);
				
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				AdminInv.Wetter.setItem(3, Storm);
				AdminInv.Wetter.setItem(4, Clear);
				AdminInv.Wetter.setItem(5, Thundering);
				
				AdminInv.Wetter.setItem(7, Day);
				AdminInv.Wetter.setItem(8, Night);
				
				AdminInv.Wetter.setItem(9, Back);
				
				p.getPlayer().openInventory(AdminInv.Wetter);
			}
		}
		return true;
	}
}
