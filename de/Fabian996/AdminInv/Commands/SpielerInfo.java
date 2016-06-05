package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class SpielerInfo implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pinfo")){
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/pinfo §7<§5Spieler§7>");
			}else{
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					p.sendMessage(AdminInv.AdminPrefix + "Spieler §6" + args[0] + " §rnicht gefunden");
				}else{
					Location loc = target.getLocation();
					if(p.hasPermission("admininv.spielerinfo") || (p.hasPermission("admininv.*"))){
						cs.sendMessage(AdminInv.AdminPrefix + "§6+--------------§7Spieler Info§6---------------+");	
						cs.sendMessage(AdminInv.AdminPrefix + "§cNick: §2" + target.getName());
						cs.sendMessage(AdminInv.AdminPrefix + "§cXp: §2" + target.getExp());
						cs.sendMessage(AdminInv.AdminPrefix + "§cCoordis: §2" + "X: " + loc.getBlockX() + " Y: " + loc.getBlockY() + " Z: " + loc.getBlockZ());
						cs.sendMessage(AdminInv.AdminPrefix + "§cWorld: §2" + target.getWorld().getName());
						cs.sendMessage(AdminInv.AdminPrefix + "                                        ");
						cs.sendMessage(AdminInv.AdminPrefix + "§cBanned: §2" + target.isBanned() + "          " + "§cOp: §2" + target.isOp());
						cs.sendMessage(AdminInv.AdminPrefix + "§cGamemode: §2" + target.getGameMode() + "          " + "§cFly: §2" + target.isFlying());
						cs.sendMessage(AdminInv.AdminPrefix + "                                        ");
						cs.sendMessage(AdminInv.AdminPrefix + "§cIP: §2" + target.getAddress());
						cs.sendMessage(AdminInv.AdminPrefix + "§cUUID: §2" + target.getUniqueId());
						cs.sendMessage(AdminInv.AdminPrefix + "§cEffect: §2" + target.getActivePotionEffects());
						cs.sendMessage(AdminInv.AdminPrefix + "§6+--------------§7Spieler Info§6---------------+");	
					}else{
						cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
					}
				}
			}
		}
		return true;
	}
}
