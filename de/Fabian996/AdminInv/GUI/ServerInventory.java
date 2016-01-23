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

public class ServerInventory implements CommandExecutor {

	@SuppressWarnings("unused")
	private static AdminMain instance;
	
	Inventory Server = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("server")){
			if(p.hasPermission("AdminInv.Admin")){
				p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 100.0F, 16.0F);
				Server = p.getPlayer().getServer().createInventory(null, 18, "§0Server Inventory");
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
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				Server.setItem(2, Ja);
				Server.setItem(6, Nein);
				
				Server.setItem(9, Back);
				
				p.getPlayer().openInventory(Server);
			}	
		}
		return true;
	}
}
