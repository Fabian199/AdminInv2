package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Invsee implements CommandExecutor {

	private String  cmdHelp = "Nutze: §3/invsee §7<§5Spieler§7> §7<§5ender§6/§5Inv§7>";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("invsee")){
			Player p = (Player)cs;
			if(!(cs instanceof Player)){
				cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
			}
			if(p.hasPermission("admininv.invsee") || (p.hasPermission("admininv.*"))){
				if(args.length < 2){
					p.sendMessage(AdminInv.AdminPrefix + cmdHelp);
					return true;
				}else if(args.length == 2){
					Player target = Bukkit.getPlayer(args[0]);
					if(target.isOnline()){
						if(args[1].equalsIgnoreCase("ender")){
							Inventory EnderChest = target.getEnderChest();
							p.openInventory(EnderChest);
							return true;
						}else if(args[1].equalsIgnoreCase("inv")){
							p.openInventory(target.getInventory());
							return true;
						}
					}else{
						p.sendMessage(AdminInv.AdminPrefix + "§7Der Spieler §6" +  args[0]  + " §7ist nicht onlein");
					}
				}
			}else{
				p.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
			}
		}
		return true;
	}
}
