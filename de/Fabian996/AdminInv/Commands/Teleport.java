package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.API.TeleportAPI;
import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;


public class Teleport implements CommandExecutor{

	private String Spieler_Nicht_Onlein = "§7Der Spieler §6";
	private String tpMSG = "§7Du würdst zu §6";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("atp")){
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
				return true;
			}
			if(args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					p.sendMessage(AdminInv.AdminPrefix + Spieler_Nicht_Onlein);
				}
				TeleportAPI.teleportPlayer(p, target.getLocation());
				p.sendMessage(AdminInv.AdminPrefix + tpMSG + target.getName() + " §7Teleportiert");
			}
			if(args.length == 2){
				if(p.hasPermission("admininv.teleport") || (p.hasPermission("admininv.*"))){
					Player target = Bukkit.getPlayer(args[0]);
					Player target1 = Bukkit.getPlayer(args[1]);
					try{
						TeleportAPI.teleportPlayer(target, target1.getLocation());
						p.sendMessage(AdminInv.AdminPrefix + "§7Teleportiert §6" + target.getName() + " §7zum Spieler §3" + target1.getName());
					}catch(Exception e){
						p.sendMessage(AdminInv.AdminPrefix + Spieler_Nicht_Onlein + args[1] + " §7ist nicht onlein!");
					}
				}
			}
		}
		return true;
	}
}
