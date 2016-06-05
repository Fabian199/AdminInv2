package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class renameItem implements CommandExecutor{

	private String cmdHelp = "Nutze: §3/rename §7<§5ItemName§7>";
	private String Not_Item_In_The_Hand = "§cDu musst ein Item in der Hand halten.";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("rename")){
			if((cs instanceof Player)){
				Player p = (Player)cs;
				if(p.hasPermission("admininv.rename") || p.hasPermission("admininv.*")){
					if((p.getItemInHand() != null) && (!p.getItemInHand().getType().equals(Material.AIR))){
						if(args.length == 1){
							ItemStack Item = p.getItemInHand();
						
							String string = args[0];
							String SpeaceString = string.replaceAll("_", " ");
							String ColorString = ChatColor.translateAlternateColorCodes('&', SpeaceString);
						
							ItemMeta Itemmeta = Item.getItemMeta();
							Itemmeta.setDisplayName(ColorString);
							Item.setItemMeta(Itemmeta);
						
							p.sendMessage(AdminInv.AdminPrefix + "Erfolgreich das Item in der Hand umbenannt\n" + AdminInv.AdminPrefix + "§7Das Item heißt jetzt §r" + ColorString);
						}else{
							cs.sendMessage(AdminInv.AdminPrefix  + cmdHelp);
						}
					}else{
						cs.sendMessage(AdminInv.AdminPrefix  + Not_Item_In_The_Hand);
					}
				}else{
					cs.sendMessage(AdminInv.AdminPrefix  + AdminInv.NoPerm);
				}
			}else{
				cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
			}
		}
		return true;
	}
}
