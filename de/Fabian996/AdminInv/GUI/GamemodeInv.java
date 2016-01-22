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

public class GamemodeInv implements CommandExecutor {
	
	public Inventory Gamemode = null;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("egm")){
			if(p.hasPermission("AdminInv.Gamemode")){
				p.playSound(p.getLocation(), Sound.ARROW_HIT, 1000.0F, 6.0F);
				Gamemode = p.getPlayer().getServer().createInventory(null, 18, "§0Gamemode Inventory");
				// Inventar Erstellt...
				
				// Icons im Inventar festlegen..
				ItemStack SM = new ItemStack(Material.BED);
				ItemMeta SMmeta = SM.getItemMeta();
				ArrayList<String> SuM = new ArrayList<String>();
				SMmeta.setDisplayName("§6Survival Mode");
				SuM.add("§2You can put yourself in Survival mode");
				SMmeta.setLore(SuM);
				SM.setItemMeta(SMmeta);
				
				ItemStack CM = new ItemStack(Material.BEDROCK);
				ItemMeta CMmeta = CM.getItemMeta();
				ArrayList<String> CrM = new ArrayList<String>();
				CMmeta.setDisplayName("§4Creative Mode");
				CrM.add("§6You can put yourself in Creative mode");
				CMmeta.setLore(CrM);
				CM.setItemMeta(CMmeta);

				ItemStack AM = new ItemStack(Material.STONE_SWORD);
				ItemMeta AMmeta = AM.getItemMeta();
				ArrayList<String> AdM = new ArrayList<String>();
				AMmeta.setDisplayName("§3Adventure Mode");
				AdM.add("§eYou can put yourself in Adventure mode");
				AMmeta.setLore(AdM);
				AM.setItemMeta(AMmeta);
				
				ItemStack SpM = new ItemStack(Material.BONE);
				ItemMeta SpMmeta = SpM.getItemMeta();
				ArrayList<String> SPM = new ArrayList<String>();
				SpMmeta.setDisplayName("§5Spectator Mode");
				SPM.add("§eYou can put yourself in Spectator mode");
				SpMmeta.setLore(SPM);
				SpM.setItemMeta(SpMmeta);
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Back to Inventory");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				Gamemode.setItem(2, SM);
				Gamemode.setItem(3, CM);
				Gamemode.setItem(4, AM);
				Gamemode.setItem(5, SpM);
				
				Gamemode.setItem(9, Back);
				
				p.getPlayer().openInventory(Gamemode);
				}
		}
		return true;
	}
}
