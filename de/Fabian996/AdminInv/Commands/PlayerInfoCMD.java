package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInfoCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pinfo")){
			if(args.length == 0 ){
				cs.sendMessage(Prefix + "Use §6/pinfo §3<player>");
			}else{
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					cs.sendMessage(Prefix + "Player §6" + args[0] + "§f not found");
				}else{
					Location loc = target.getLocation();
					if(cs.hasPermission("AdminInv.PlayerInfo")){
						cs.sendMessage(Prefix + "§6+----------------§7PlayerInfo§6-----------------+");	
						cs.sendMessage(Prefix + "§cNick: §2" + target.getName());
						cs.sendMessage(Prefix + "§cXp: §2" + target.getExp());
						cs.sendMessage(Prefix + "§cCoordis: §2" + "X: " + loc.getBlockX() + " Y: " + loc.getBlockY() + " Z: " + loc.getBlockZ());
						cs.sendMessage(Prefix + "§cWorld: §2" + target.getWorld().getName());
						cs.sendMessage(Prefix + "                                        ");
						cs.sendMessage(Prefix + "§cBanned: §2" + target.isBanned() + "          " + "§cOp: §2" + target.isOp());
						cs.sendMessage(Prefix + "§cGamemode: §2" + target.getGameMode() + "          " + "§cFly: §2" + target.isFlying());
						cs.sendMessage(Prefix + "                                        ");
						cs.sendMessage(Prefix + "§cIP: §2" + target.getAddress());
						cs.sendMessage(Prefix + "§cUUID: §2" + target.getUniqueId());
						cs.sendMessage(Prefix + "§cEffect: §2" + target.getActivePotionEffects());
						cs.sendMessage(Prefix + "§6+----------------§7PlayerInfo§6-----------------+");	
					}else{
						cs.sendMessage(Prefix + "You dont have permissions to do this!");
					}
				}
			}
		}
		return false;
	}
}
