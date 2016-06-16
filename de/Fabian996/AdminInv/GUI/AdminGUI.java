package com.jimdo.Fabian996.AdminInv2.GUI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class AdminGUI implements CommandExecutor{
	
	
	
	public AdminGUI(AdminInv adminInv) {
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("admin")){
			if((p.hasPermission("admininv.admin") || (p.hasPermission("admininv.*")))){
				AdminInv.inv = p.getPlayer().getServer().createInventory(null, 27 ,"§4Admin GUI");
				
				ItemStack Heal = new ItemStack(Material.POTION);
				ItemMeta Healmeta = Heal.getItemMeta();
				Healmeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
				ArrayList<String> Heal1 = new ArrayList<String>();
				Healmeta.setDisplayName("§cHeal");
				Heal1.add("Du wirst geheilt!");
				Healmeta.setLore(Heal1);
				Heal.setItemMeta(Healmeta);
				
				ItemStack Fly = new ItemStack(Material.FEATHER);
				ItemMeta Flymeta = Fly.getItemMeta();
				ArrayList<String> Flyi = new ArrayList<String>();
				Flymeta.setDisplayName("§7Fly §8<§aon§8/§4off§8>");
				Flyi.add("§3Du kannst Fliegen");
				Flymeta.setLore(Flyi);
				Fly.setItemMeta(Flymeta);
				
				ItemStack Weather = new ItemStack(Material.WATER_BUCKET);
				ItemMeta Weathermeta = Weather.getItemMeta();
				ArrayList<String> WeatherM = new ArrayList<String>();
				Weathermeta.setDisplayName("§2Wetter/Zeit Inventar");
				WeatherM.add("Hier siehst du alle Wetter Funktion!");
				Weathermeta.setLore(WeatherM);
				Weather.setItemMeta(Weathermeta);
				
				ItemStack GM = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta GMmeta = GM.getItemMeta();
				GMmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				GMmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				GMmeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
				GMmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				GMmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
				ArrayList<String> GameMode = new ArrayList<String>();
				GMmeta.setDisplayName("§6Gamemode Inventar");
				GameMode.add("Hier siehst du alle Gamemode Funktion!");
				GMmeta.setLore(GameMode);
				GM.setItemMeta(GMmeta);
				
				ItemStack Diffi = new ItemStack(Material.CACTUS);
				ItemMeta Diffimeta = Diffi.getItemMeta();
				ArrayList<String> Diff = new ArrayList<String>();
				Diffimeta.setDisplayName("§3Difficulty Inventar");
				Diff.add("Hier siehst du alle Difficulty Funktion!");
				Diffimeta.setLore(Diff);
				Diffi.setItemMeta(Diffimeta);
				
				ItemStack Vanish = new ItemStack(Material.SLIME_BALL);
				ItemMeta Vanishmeta = Vanish.getItemMeta();
				Vanishmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
				Vanishmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Vanishmeta.setDisplayName("§5Vanish");
				Vanish.setItemMeta(Vanishmeta);
				
				ItemStack Reload = new ItemStack(Material.SPONGE);
				ItemMeta Reloadmeta = Reload.getItemMeta();
				Reloadmeta.setDisplayName("§5Neuladen des Servers");
				Reload.setItemMeta(Reloadmeta);
				
				ItemStack ConfigReload = new ItemStack(Material.BOOK_AND_QUILL);
				ItemMeta ConfigReloadmeta = ConfigReload.getItemMeta();
				ConfigReloadmeta.setDisplayName("§2Config neuladen");
				ConfigReload.setItemMeta(ConfigReloadmeta);
				
				ItemStack Stop = new ItemStack(Material.BARRIER);
				ItemMeta Stopmeta = Stop.getItemMeta();
				Stopmeta.setDisplayName("§4Stop the Server");
				Stop.setItemMeta(Stopmeta);
				
				ItemStack PlayerSkull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				SkullMeta PlayerSkullmeta = (SkullMeta) PlayerSkull.getItemMeta();
				PlayerSkullmeta.setOwner(cs.getName());
				PlayerSkullmeta.setDisplayName("§5Online Spieler´s");
				ArrayList<String> Spieler = new ArrayList<>();
				Spieler.add("§7Kommt bald");
				PlayerSkullmeta.setLore(Spieler);
				PlayerSkull.setItemMeta(PlayerSkullmeta);
			

				AdminInv.inv.setItem(0, Heal);
				AdminInv.inv.setItem(3, Weather);
				AdminInv.inv.setItem(4, GM);
				AdminInv.inv.setItem(5, Diffi);
				AdminInv.inv.setItem(8, Fly);
				
				AdminInv.inv.setItem(18, ConfigReload);			
				AdminInv.inv.setItem(21, Reload);
				AdminInv.inv.setItem(22, Vanish);
				AdminInv.inv.setItem(23, Stop);
				
				AdminInv.inv.setItem(26, PlayerSkull);
						
				p.getPlayer().openInventory(AdminInv.inv);
			}
		}
		return true;
	}
}
