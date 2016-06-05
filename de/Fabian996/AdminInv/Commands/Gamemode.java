package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Gamemode implements CommandExecutor {

	private String cmdHelp = "Nutze §3/egm §7<§50§6/§51§6/§52§6/§53§7>";
	//Gamemode selber ändern
	private String gm0 = "§7Du befindest dich im Survial Modus §6";
	private String gm1 = "§7Du befindest dich im Creative Modus §6";
	private String gm2 = "§7Du befindest dich im Adventure Modus §6";
	private String gm3 = "§7Du befindest dich im Spectator Modus §6";

	
	@SuppressWarnings({ "deprecation", "null" })
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("egm")){
			if(p.hasPermission("admininv.egm") || p.hasPermission("admininv.*")){
				if(args.length == 0){
					p.sendMessage(AdminInv.AdminPrefix + cmdHelp);
					return true;
				}
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("0")){
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(AdminInv.AdminPrefix + gm0 + p.getName());
						return true;
					}
					if(args[0].equalsIgnoreCase("1")){
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(AdminInv.AdminPrefix + gm1 + p.getName());
						return true;
					}
					if(args[0].equalsIgnoreCase("2")){
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(AdminInv.AdminPrefix + gm2 + p.getName());
						return true;
					}
					if(args[0].equalsIgnoreCase("3")){
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(AdminInv.AdminPrefix + gm3 + p.getName());
						return true;
					}
				}
				if(args.length == 2){
					//Gamemode andere Spieler ändern
					String gmo0 = "§7Du hast den Spieler §6" + args[1] + " §7in den Survial Modus gesetzt";
					String gmo1 = "§7Du hast den Spieler §6" + args[1] + " §7in den Creative Modus gesetzt";
					String gmo2 = "§7Du hast den Spieler §6" + args[1] + " §7in den Adventure Modus gesetzt";
					String gmo3 = "§7Du hast den Spieler §6" + args[1] + " §7in den Spectator Modus gesetzt";

					Player target = Bukkit.getPlayer(args[1]);
					if(args[0].equalsIgnoreCase("0")){
						if(target == null){
							p.sendMessage(AdminInv.AdminPrefix + "§cDer Spieler §6" + target.getName() + " §cist nicht onlein");
						}else{
							target.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(AdminInv.AdminPrefix + gmo0);
							return true;
						}
					}
					if(args[0].equalsIgnoreCase("1")){
						if(target == null){
							p.sendMessage(AdminInv.AdminPrefix + "§cDer Spieler §6" + target.getName() + " §cist nicht onlein");
						}else{
							target.setGameMode(GameMode.CREATIVE);
							p.sendMessage(AdminInv.AdminPrefix + gmo1);
							return true;
						}
					}
					if(args[0].equalsIgnoreCase("2")){
						if(target == null){
							p.sendMessage(AdminInv.AdminPrefix + "§cDer Spieler §6" + target.getName() + " §cist nicht onlein");
						}else{
							target.setGameMode(GameMode.ADVENTURE);
							p.sendMessage(AdminInv.AdminPrefix + gmo2);
							return true;
						}
					}
					if(args[0].equalsIgnoreCase("3")){
						if(target == null){
							p.sendMessage(AdminInv.AdminPrefix + "§cDer Spieler §6" + target.getName() + " §cist nicht onlein");
						}else{
							target.setGameMode(GameMode.SPECTATOR);
							p.sendMessage(AdminInv.AdminPrefix + gmo3);
							return true;
						}
					}
				}
			}
		}
		return true;
	}
}
