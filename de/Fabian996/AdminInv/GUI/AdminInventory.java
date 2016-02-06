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

import de.Fabian996.AdminInv.Main.AdminMain;

public class AdminInventory implements CommandExecutor {

	@SuppressWarnings("unused")
	private static AdminMain instance;

	public Inventory Inv = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player pl = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("admin")){
			if(pl.hasPermission("AdminInv.Admin") || pl.hasPermission("AdminInv.*")){
				pl.playSound(pl.getLocation(), Sound.FIREWORK_BLAST, 100.0F, 16.0F);
				Inv = pl.getPlayer().getServer().createInventory(null, 27, "§0Admin Inventory");
				// Inventar Erstellt...
					
				// Icons im Inventar festlegen..
				ItemStack Heal = new ItemStack(Material.POTION);
				ItemMeta Healmeta = Heal.getItemMeta();
				ArrayList<String> Heal1 = new ArrayList<String>();
				Healmeta.setDisplayName("§cHeal");
				Heal1.add("You are healed! ");
				Healmeta.setLore(Heal1);
				Heal.setItemMeta(Healmeta);
				
				ItemStack Fly = new ItemStack(Material.FEATHER);
				ItemMeta Flymeta = Fly.getItemMeta();
				ArrayList<String> Flyi = new ArrayList<String>();
				Flymeta.setDisplayName("§7Fly §8<§aon§8/§4off§8>");
				Flyi.add("§3You can now Fly");
				Flymeta.setLore(Flyi);
				Fly.setItemMeta(Flymeta);
				
				ItemStack Weather = new ItemStack(Material.WATER_BUCKET);
				ItemMeta Weathermeta = Weather.getItemMeta();
				ArrayList<String> WeatherM = new ArrayList<String>();
				Weathermeta.setDisplayName("§2Weather/Time Inventory");
				WeatherM.add("Here you see all Weather function");
				Weathermeta.setLore(WeatherM);
				Weather.setItemMeta(Weathermeta);
				
				ItemStack GM = new ItemStack(Material.PACKED_ICE);
				ItemMeta GMmeta = GM.getItemMeta();
				ArrayList<String> GameMode = new ArrayList<String>();
				GMmeta.setDisplayName("§6Gamemode Inventory");
				GameMode.add("Here you see all Gamemode function");
				GMmeta.setLore(GameMode);
				GM.setItemMeta(GMmeta);
				
				ItemStack Diffi = new ItemStack(Material.CACTUS);
				ItemMeta Diffimeta = Diffi.getItemMeta();
				ArrayList<String> Diff = new ArrayList<String>();
				Diffimeta.setDisplayName("§3Difficulty Inventory");
				Diff.add("Here you see all Difficulty function");
				Diffimeta.setLore(Diff);
				Diffi.setItemMeta(Diffimeta);
				
				ItemStack Extra = new ItemStack(Material.SNOW_BLOCK);
				ItemMeta Extrameta = Extra.getItemMeta();
				ArrayList<String> ExtraI = new ArrayList<String>();
				Extrameta.setDisplayName("§5Extra Inventory");
				ExtraI.add("§fHere you see all Extra function");
				Extrameta.setLore(ExtraI);
				Extra.setItemMeta(Extrameta);
				
				ItemStack Reload = new ItemStack(Material.SPONGE);
				ItemMeta Reloadmeta = Reload.getItemMeta();
				Reloadmeta.setDisplayName("§5Reload the Server");
				Reload.setItemMeta(Reloadmeta);
				
				ItemStack ConfigReload = new ItemStack(Material.BOOK_AND_QUILL);
				ItemMeta ConfigReloadmeta = ConfigReload.getItemMeta();
				ConfigReloadmeta.setDisplayName("§2Config Reload");
				ConfigReload.setItemMeta(ConfigReloadmeta);
				
				ItemStack Stop = new ItemStack(Material.BARRIER);
				ItemMeta Stopmeta = Stop.getItemMeta();
				Stopmeta.setDisplayName("§4Stop the Server");
				Stop.setItemMeta(Stopmeta);

				Inv.setItem(0, Heal);
				Inv.setItem(3, Weather);
				Inv.setItem(4, GM);
				Inv.setItem(5, Diffi);
				Inv.setItem(8, Fly);
				
				Inv.setItem(18, ConfigReload);						
				Inv.setItem(21 , Reload);
				Inv.setItem(22, Extra);
				Inv.setItem(23 , Stop);
						
				pl.getPlayer().openInventory(Inv);
			}
		}		
		return false;
	}
}
