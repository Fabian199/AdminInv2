package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Heal implements CommandExecutor{
	
	private String heal = "§7Du würdest geheilt";
	private String heal1 = "§7Du würdest geheilt von §6";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cs instanceof Player){
			Player p = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("heal")){
				if(args.length == 0){
					if(p.hasPermission("admininv.heal") || (p.hasPermission("admininv.*"))){
						p.setHealth(20D);
						p.setFoodLevel(20);
						p.setFireTicks(0);
						p.getActivePotionEffects().clear();
						p.sendMessage(AdminInv.AdminPrefix + heal);
					}else{
						p.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
					}
				}else if(args.length == 1){
					if(p.hasPermission("admininv.healother") || (p.hasPermission("admininv.*"))){
						Player target = Bukkit.getPlayer(args[0]);
						String SpielerOfflein = "§cDer Spieler §6" + target.getName() + " §cist nicht onlein";
						if((target == null) || (target.isOnline())){
							p.sendMessage(AdminInv.AdminPrefix + SpielerOfflein);
							return true;
						}
						target.setHealth(20D);
						target.setFoodLevel(20);
						target.setFireTicks(0);
						target.getActivePotionEffects().clear();
						p.sendMessage(AdminInv.AdminPrefix + heal1 + p.getName());
						
					}else{
						p.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
					}
				}
			}
		}else{
			cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
		}
		return true;
	}
}
