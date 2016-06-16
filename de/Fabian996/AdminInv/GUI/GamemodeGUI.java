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

public class GamemodeGUI implements CommandExecutor {

	public GamemodeGUI(AdminInv adminInv) {
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("gamem")){
			if(p.hasPermission("admininv.admin") || p.hasPermission("adminInv.*")){
				AdminInv.GameMode = p.getPlayer().getServer().createInventory(null, 18, "§6Gamemode Inventar");
				// Inventar Erstellt...
				
				// Icons im Inventar festlegen..
				ItemStack SM = new ItemStack(Material.BED);
				ItemMeta SMmeta = SM.getItemMeta();
				ArrayList<String> SuM = new ArrayList<String>();
				SMmeta.setDisplayName("§6Survival Modus");
				SuM.add("§2Du kannst dich in den Survival Modus setzen");
				SMmeta.setLore(SuM);
				SM.setItemMeta(SMmeta);
				
				ItemStack CM = new ItemStack(Material.BEDROCK);
				ItemMeta CMmeta = CM.getItemMeta();
				ArrayList<String> CrM = new ArrayList<String>();
				CMmeta.setDisplayName("§4Creative Modus");
				CrM.add("§6Du kannst dich in den Creative Modus setzen");
				CMmeta.setLore(CrM);
				CM.setItemMeta(CMmeta);

				ItemStack AM = new ItemStack(Material.STONE_SWORD);
				ItemMeta AMmeta = AM.getItemMeta();
				ArrayList<String> AdM = new ArrayList<String>();
				AMmeta.setDisplayName("§3Adventure Modus");
				AdM.add("§eDu kannst dich in den Adventure Modus setzen");
				AMmeta.setLore(AdM);
				AM.setItemMeta(AMmeta);
				
				ItemStack SpM = new ItemStack(Material.BONE);
				ItemMeta SpMmeta = SpM.getItemMeta();
				ArrayList<String> SPM = new ArrayList<String>();
				SpMmeta.setDisplayName("§5Spectator Modus");
				SPM.add("§eDu kannst dich in den Spectator Modus setzen");
				SpMmeta.setLore(SPM);
				SpM.setItemMeta(SpMmeta);
				
				ItemStack Back = new ItemStack(Material.GOLD_NUGGET);
				ItemMeta Backmeta = Back.getItemMeta();
				ArrayList<String> BM = new ArrayList<String>();
				Backmeta.setDisplayName("§aBack");
				BM.add("Zurück zum Inventar");
				Backmeta.setLore(BM);
				Back.setItemMeta(Backmeta);

				AdminInv.GameMode.setItem(2, SM);
				AdminInv.GameMode.setItem(3, CM);
				AdminInv.GameMode.setItem(4, AM);
				AdminInv.GameMode.setItem(5, SpM);
				
				AdminInv.GameMode.setItem(9, Back);
				
				p.getPlayer().openInventory(AdminInv.GameMode);
				}
		}
		return true;
	}
}
