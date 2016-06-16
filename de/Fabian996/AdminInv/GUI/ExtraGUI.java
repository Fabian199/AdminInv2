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

public class ExtraGUI implements CommandExecutor {

	
	public ExtraGUI(AdminInv adminInv) {
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("extra")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("admininv.*")){
				AdminInv.ExtraInv = p.getPlayer().getServer().createInventory(null, 18, "§0Extra Inventar");
				
				ItemStack ClearChat = new ItemStack(Material.BUCKET);
				ItemMeta ClearChatmeta = ClearChat.getItemMeta();
				ArrayList<String> CC = new ArrayList<String>();
				ClearChatmeta.setDisplayName("§2Clear Chat");
				CC.add("");
				ClearChatmeta.setLore(CC);
				ClearChat.setItemMeta(ClearChatmeta);
				
				ItemStack Sinfo = new ItemStack(Material.DRAGON_EGG);
				ItemMeta Sinfometa = Sinfo.getItemMeta();
				ArrayList<String> SInfo = new ArrayList<String>();
				Sinfometa.setDisplayName("§6Server Information");
				SInfo.add("Zeigt alle Server Information an");
				Sinfometa.setLore(SInfo);
				Sinfo.setItemMeta(Sinfometa);
				
				ItemStack Vote = new ItemStack(Material.PAPER);
				ItemMeta Votemeta = Vote.getItemMeta();
				ArrayList<String> VOTE = new ArrayList<String>();
				Votemeta.setDisplayName("§3Vote Links");
				VOTE.add("Zeigt alle Vote Links an");
				Votemeta.setLore(VOTE);
				Vote.setItemMeta(Votemeta);
				
				ItemStack KickAll = new ItemStack(Material.ROTTEN_FLESH);
				ItemMeta KickAllmeta = KickAll.getItemMeta();
				KickAllmeta.setDisplayName("§2Alle Spieler vom Server kicken");
				KickAll.setItemMeta(KickAllmeta);
				
				ItemStack Save = new ItemStack(Material.SUGAR);
				ItemMeta Savemeta = Save.getItemMeta();
				ArrayList<String> SaveMode = new ArrayList<String>();
				Savemeta.setDisplayName("§1Save World");
				SaveMode.add("Speichern der Welt");
				Savemeta.setLore(SaveMode);
				Save.setItemMeta(Savemeta);
				
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Sinfometa.setDisplayName("§6Server Information");
				Backmeta.setDisplayName("§aBack");
				BM.add("Zurück zum Inventar");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);
				
				
				AdminInv.ExtraInv.setItem(2, ClearChat);
				AdminInv.ExtraInv.setItem(3, Sinfo);
				AdminInv.ExtraInv.setItem(4, Vote);
				AdminInv.ExtraInv.setItem(5, KickAll);
				AdminInv.ExtraInv.setItem(6, Save);
				
				AdminInv.ExtraInv.setItem(9, Back);
				
				p.openInventory(AdminInv.ExtraInv);
			}
		}
		return false;
	}

}
