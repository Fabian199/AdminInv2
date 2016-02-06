package de.Fabian996.AdminInv.GUI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExtraInv implements CommandExecutor {

	public Inventory ExtraInv = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("extra")){
			if(p.hasPermission("AdminInv.Admin") || p.hasPermission("AdminInv.*")){
				ExtraInv = p.getPlayer().getServer().createInventory(null, 18, "§0Extra Inventory");
				
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
				SInfo.add("Show Server Information");
				Sinfometa.setLore(SInfo);
				Sinfo.setItemMeta(Sinfometa);
				
				ItemStack Vote = new ItemStack(Material.PAPER);
				ItemMeta Votemeta = Vote.getItemMeta();
				ArrayList<String> VOTE = new ArrayList<String>();
				Votemeta.setDisplayName("§3Vote Links");
				VOTE.add("Show Vote Links");
				Votemeta.setLore(VOTE);
				Vote.setItemMeta(Votemeta);
				
				ItemStack KickAll = new ItemStack(Material.ROTTEN_FLESH);
				ItemMeta KickAllmeta = KickAll.getItemMeta();
				KickAllmeta.setDisplayName("§2Kick All Player´s");
				KickAll.setItemMeta(KickAllmeta);
				
				ItemStack Save = new ItemStack(Material.SUGAR);
				ItemMeta Savemeta = Save.getItemMeta();
				ArrayList<String> SaveMode = new ArrayList<String>();
				Savemeta.setDisplayName("§1Save World");
				SaveMode.add("You save the World");
				Savemeta.setLore(SaveMode);
				Save.setItemMeta(Savemeta);
				
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Sinfometa.setDisplayName("§6Server Information");
				Backmeta.setDisplayName("§aBack");
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);
				
				
				ExtraInv.setItem(2, ClearChat);
				ExtraInv.setItem(3, Sinfo);
				ExtraInv.setItem(4, Vote);
				ExtraInv.setItem(5, KickAll);
				ExtraInv.setItem(6, Save);
				
				ExtraInv.setItem(9, Back);
				
				p.openInventory(ExtraInv);
			}
		}
		return false;
	}

}
