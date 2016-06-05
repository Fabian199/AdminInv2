package com.jimdo.Fabian996.AdminInv2.Commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ServerInfo implements CommandExecutor {

	private String cmdHelp = "Nutze: §3setinfo §7<§5website§6/§5ts§6/§5forum§7>";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("sinfo")){
			String Website = AdminInv.cfg.getString("serverinfo.website");
			String Teamspeak = AdminInv.cfg.getString("serverinfo.teamspeak");
			String Forum = AdminInv.cfg.getString("serverinfo.forum");
			
			p.sendMessage(AdminInv.AdminPrefix + "§6+------------+§bServer Information§6+------------+");		
			p.sendMessage(AdminInv.AdminPrefix + "§7Website: §2" + Website);
			p.sendMessage(AdminInv.AdminPrefix + "§7Teamspeak: §2" + Teamspeak);
			p.sendMessage(AdminInv.AdminPrefix + "§7Forum: §2" + Forum);
			p.sendMessage(AdminInv.AdminPrefix + "§6+------------+§bServer Information§6+------------+");	
			return true;	
		}
		
		if(cmd.getName().equalsIgnoreCase("setinfo")){
			if(args.length <1){
				p.sendMessage(AdminInv.AdminPrefix + cmdHelp);
			}
			if(args.length == 2){
				if(p.hasPermission("admininv.setinfo") || (p.hasPermission("admininv.*"))){
					if(args[0].equalsIgnoreCase("website")){
						if(args.length != 1){
							String Message = "";
							for(int i = 1; i < args.length; i++){
								Message = Message + " " + args[i];
							}
							AdminInv.cfg.set("serverinfo.website", Message);
							try {
								AdminInv.cfg.save(AdminInv.file);
								p.sendMessage(AdminInv.AdminPrefix + "§7Erfolgreich gesetzt");
							} catch (IOException e) {
							}
						}
					}
					if(args[0].equalsIgnoreCase("ts")){
						if(args.length != 1){
							String Message = "";
							for(int i = 1; i < args.length; i++){
								Message = Message + " " + args[i];
							}
							AdminInv.cfg.set("serverinfo.teamspeak", Message);
							try {
								AdminInv.cfg.save(AdminInv.file);
								p.sendMessage(AdminInv.AdminPrefix + "§7Erfolgreich gesetzt");
							} catch (IOException e) {
							}
						}
					}
					if(args[0].equalsIgnoreCase("forum")){
						if(args.length != 1){
							String Message = "";
							for(int i = 1; i < args.length; i++){
								Message = Message + " " + args[i];
							}
							AdminInv.cfg.set("serverinfo.forum", Message);
							try {
								AdminInv.cfg.save(AdminInv.file);
								p.sendMessage(AdminInv.AdminPrefix + "§7Erfolgreich gesetzt");
							} catch (IOException e) {
							}
						}
					}
				}
			}
		}
		return true;
	}
}
