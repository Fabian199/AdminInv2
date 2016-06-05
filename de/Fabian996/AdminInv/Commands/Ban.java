package com.jimdo.Fabian996.AdminInv2.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Ban implements CommandExecutor {

	public static ArrayList<String> Banliste = new ArrayList<String>();
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		if(!(cs instanceof Player)){
			cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("aban")){
			if(cs.hasPermission("admininv.ban") || (cs.hasPermission("admininv.*"))){
				if(args.length == 0){
					cs.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/aban §7<§5Spieler§7> §7<§cGrund§7>");
					return true;
				}
				OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
				String Grund = args[1];
				for(int i = 2; i < args.length; i++){
					Grund = Grund + " " + args[i];
				}
				if(Bukkit.getPlayer(args[0]) != null){
					Player target = Bukkit.getPlayer(args[0]);
					String Forum = AdminInv.cfg.getString("serverinfo.forum");
					String TeamSpeak = AdminInv.cfg.getString("serverinfo.teamspeak");
					target.kickPlayer("§4§lDu bist permanent vom Server gebannt\n \n§r§4§lGrund: §r§2" +  Grund + "\n\n§6Bitte melde dich im Forum oder im TS \n§4§lForum:§r§8" + Forum + "\n§4§lTeamSpeak:§r§8" + TeamSpeak);
				}
				cs.sendMessage(AdminInv.BanPrefix + "§7Der Spieler §6" + op.getName() + " §7ist Permanent vom Server gebannt \n" + AdminInv.BanPrefix + "§2Grund: §6" + Grund);
				Banliste.add(args[0]);
				AdminInv.bancfg.set("Ban." + op.getName() + ".Enable", Boolean.valueOf(true));
				AdminInv.bancfg.set("Ban." + op.getName() + ".Grund", Grund);
				try{
					AdminInv.bancfg.save(AdminInv.banfile);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
}
