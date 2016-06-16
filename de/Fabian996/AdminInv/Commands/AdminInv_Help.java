package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class AdminInv_Help implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private static AdminInv instance;
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
		}
		if(cmd.getName().equalsIgnoreCase("ahelp")){
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage(AdminInv.AdminPrefix + "§8------------ §aUser Befehle §7[§31/2§7]§8 ------------");
				p.sendMessage(AdminInv.AdminPrefix + "§3/warps §6- §fZeigt alle Warp Punkte an");
				p.sendMessage(AdminInv.AdminPrefix + "§3/warp §7[Warpname] §6- §fTeleportieren zum Warp Punkt");
				p.sendMessage(AdminInv.AdminPrefix + "§3/ping §6- §fDu siehst dein Ping");
				p.sendMessage(AdminInv.AdminPrefix + "§3/vote §6- §fZeigt alle Vote Links an");
				p.sendMessage(AdminInv.AdminPrefix + "§3/sinfo §6- §fZeigt die Server Information an");
				p.sendMessage(AdminInv.AdminPrefix + "§3/msg §7<§aSpieler§7> §7<§5Nachricht§7> §6- §fPrivate Nachricht");
				p.sendMessage(AdminInv.AdminPrefix + " ");
				p.sendMessage(AdminInv.AdminPrefix + "§fNutze §6§l/ahelp 2 §rfür die nächste Seite");
				p.sendMessage(AdminInv.AdminPrefix + "§8------------ §aUser Befehle §7[§31/2§7]§8 ------------");
				p.sendMessage(" ");
                return true;
			}
			if(args.length == 1){
				 if(args[0].equalsIgnoreCase("2")){
					 p.sendMessage(AdminInv.AdminPrefix + "§8------------ §aUser Befehle §7[§32/2§7]§8 ------------");
					 p.sendMessage(AdminInv.AdminPrefix + "§3/r §7<§5Nachricht§7> §6- §fAntworten auf Private Nachricht");
					 p.sendMessage(AdminInv.AdminPrefix + " ");
					 if(p.hasPermission("admininv.admin") || (p.hasPermission("admininv.*"))){
						 p.sendMessage(AdminInv.AdminPrefix + "§fNutze §6§l/ahelp 3 §rfür die nächste Seite");
					 }
					 p.sendMessage(AdminInv.AdminPrefix + "§8------------ §aUser Befehle §7[§32/2§7]§8 ------------");
					 p.sendMessage(" ");
				 }
				 //Admin Seite 3
				 if(args[0].equalsIgnoreCase("3")){
					 if(p.hasPermission("admininv.admin") || (p.hasPermission("admininv.*"))){
						 p.sendMessage(AdminInv.AdminPrefix + "§8----------- §4Admin Befehle §7[§31/3§7]§8 -----------");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/admin §6- §fÖfnet das Admin Inventory");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/ghast §6- §fMan bekommt das Admin Item");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/pinfo §7<§5Spieler§7> §6- §fZeigt die Spieler Information");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/br §7<§5Nachricht§7> §6- §fSenden einer BR Nachricht");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/cc §6- §fLöscht den Chat");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/glmute §6- §fAktivieren des Gloabel Mute");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/heal §7<§5Spieler§7> §6- §fSpieler Heilen oder sich Selbst");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/tc §6- §fUm im Teamchat schreiben");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/wartung §7<§5on§6/§5off§7> §6- §fWartungsmodus an/aus");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/setinfo §7<§5forum§57/§5ts§7/§5website§7> §6- §fServerInformation ändern");
						 p.sendMessage(AdminInv.AdminPrefix + " ");
						 p.sendMessage(AdminInv.AdminPrefix + "§fNutze §6§l/ahelp 4 §rfür die nächste Seite");
						 p.sendMessage(AdminInv.AdminPrefix + "§8----------- §4Admin Befehle §7[§31/3§7]§8 -----------");
						 p.sendMessage(" ");
					 }
				 }
				 if(args[0].equalsIgnoreCase("4")){
					 if(p.hasPermission("admininv.admin") || (p.hasPermission("admininv.*"))){
						 p.sendMessage(AdminInv.AdminPrefix + "§8----------- §4Admin Befehle §7[§32/3§7]§8 -----------");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/invsee §7<§5Spieler§7> §6- §fÖffnet das Inventar");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/atp §7<§5Spieler§7> §7<§5Spieler2§7> §6- §fTeleportieren");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/setwarp §7<§5warpname§7> §6- §fErstellen von Warps");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/delwarp §7<§5warpname§7> §6- §fLöschen von Warps");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/kick §7<§5Spieler§7> §7<§5Grund§7> §6- §fSpieler Kicken");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/rename §7<§5Itemname§7> §6- §fNamen ändern vom Item");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/aspy §6- §fBefehl Spy von Spielern");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/areload §6- §fConfig neuladen");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/ahelp §6- §fBefehls hilfe");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/backup §6- §fErstellen eines Backup´s");
						 p.sendMessage(AdminInv.AdminPrefix + "§3/v §6- §fUnsichbar machen für Spieler");
						 p.sendMessage(AdminInv.AdminPrefix + " ");
						 p.sendMessage(AdminInv.AdminPrefix + "§8----------- §4Admin Befehle §7[§32/3§7]§8 -----------");
					 }
				 }
			}
		}
		
		return true;
	}

}
