package com.jimdo.Fabian996.AdminInv2.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Warp implements CommandExecutor{

	private File file = new File("plugins/AdminInv2", "warps.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	private String err_need_argument = "Zu wenig Argumente";
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = null;
		if(cs instanceof Player){
			p = (Player)cs;
		}
		if(label.equalsIgnoreCase("warp")){
			if(p != null){
				if(args.length == 1){
					String str = "warps." + args[0].toLowerCase() + ".";
					World w = Bukkit.getWorld(this.cfg.getString(str + "world"));
					if(w == null){
						p.sendMessage(AdminInv.AdminPrefix + "§4Der Warp ist in einer unbekannten Welt");
						return true;
					}
					
					if(args[0] == null){
						p.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/warps");
					}
					double x = this.cfg.getDouble(str + "x");
					double y = this.cfg.getDouble(str + "y");
					double z = this.cfg.getDouble(str + "z");
					double yaw = this.cfg.getDouble(str + "yaw");
					double pitch = this.cfg.getDouble(str + "pitch");
					Location loc = new Location(w, x, y, z, (float)yaw, (float)pitch);
					p.teleport(loc);
					cs.sendMessage(AdminInv.AdminPrefix + "§7Du würdst zu Warp §6" + args[0] + " §7Teleportiert");
				}else{
					cs.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/warps");
				}
			}else{
				cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
			}
		}else if(label.equalsIgnoreCase("setwarp")){
			if(p != null){
				if(p.hasPermission("admininv.warp") || p.hasPermission("admininv.*")){
					if(args.length == 1){
						Location loc = p.getLocation();
						String str = "warps." + args[0].toLowerCase() + ".";
						this.cfg.set(str + "world", loc.getWorld().getName());
						this.cfg.set(str + "x", loc.getX());
						this.cfg.set(str + "y", loc.getY());
						this.cfg.set(str + "z", loc.getZ());
						this.cfg.set(str + "yaw", loc.getYaw());
						this.cfg.set(str + "pitch", loc.getPitch());
						try {
							this.cfg.save(this.file);
							cs.sendMessage(AdminInv.AdminPrefix + "§7Warp §6" + args[0].toLowerCase() + " §7würde erfolgreich gesetzt");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						p.sendMessage(AdminInv.AdminPrefix + this.err_need_argument);
					}
				}
			}else{
				cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
				}
		}else if (label.equalsIgnoreCase("delwarp")){
			if(args.length == 1){
				if(p.hasPermission("admininv.warp") || p.hasPermission("admininv.*")){
					this.cfg.set("warps." + args[0].toLowerCase(), null);
					try {
						this.cfg.save(file);
						cs.sendMessage(AdminInv.AdminPrefix + "§7Warp §6" + args[0].toLowerCase() + " §7würde erfolgreich gelöscht");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}if(label.equalsIgnoreCase("warps")){
			String str = "§2Warps§f: §b";
			if(str == null){
				p.sendMessage(AdminInv.AdminPrefix + "§7Bitte erstell ein Warp ");
			}
			for(String warp : this.cfg.getConfigurationSection("warps").getKeys(false)){
				str += warp + "§f,§b ";
			}
			cs.sendMessage(AdminInv.AdminPrefix + str);
		}
		return true;
	}
}
