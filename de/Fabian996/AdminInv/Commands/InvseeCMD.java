package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("invsee")){
			Player p = (Player)cs;
			if(args.length > 0){
				if(p.hasPermission("AdminInv.Invsee")){
					Player TargetP = Bukkit.getServer().getPlayer(args[0]);
					if(Bukkit.getPlayer(args[0]) == null){
						p.sendMessage(Prefix  + "§7The Player §8" + args[0] + " §7is not onlein");
					}else{
						p.openInventory(TargetP.getInventory());
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0F, -10.0F);
					}
				}else{
					cs.sendMessage(Prefix + "You dont have permissions to do this!");
				}
			}else{
				cs.sendMessage(Prefix + "Use §6/invsee §3<player>");
			}
		}
		return false;
	}

}
