package de.Fabian996.AdminInv.Commands;

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

public class WarpCMD implements CommandExecutor {
	
	private File file = new File("plugins/AdminInv", "warps.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	private String err_need_player = "You must be a player!";
	private String err_need_argument = "To many arrgument";
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
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
						p.sendMessage(Prefix + "§4Der Warp liegt in einer unbekannten Welt");
						return true;
					}
					double x = this.cfg.getDouble(str + "x");
					double y = this.cfg.getDouble(str + "y");
					double z = this.cfg.getDouble(str + "z");
					double yaw = this.cfg.getDouble(str + "yaw");
					double pitch = this.cfg.getDouble(str + "pitch");
					Location loc = new Location(w, x, y, z, (float)yaw, (float)pitch);
					p.teleport(loc);
					cs.sendMessage(Prefix + "§2Du wurdest zum Warp §6" + args[0].toLowerCase() + "§2 teleportiert");
				}else{
					cs.sendMessage(Prefix + this.err_need_argument);
				}
			}else{
				cs.sendMessage(Prefix + this.err_need_player);
			}
		}else if(label.equalsIgnoreCase("setwarp")){
			if(p != null){
				if(p.hasPermission("AdminInv.Warp")){
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
							cs.sendMessage(Prefix + "§2Warp §6" + args[0].toLowerCase() + "§2 erfolgreich gesetzt");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						p.sendMessage(Prefix + this.err_need_argument);
					}
				}
			}else{
				cs.sendMessage(Prefix + this.err_need_player);
				}
		}else if (label.equalsIgnoreCase("delwarp")){
			if(args.length == 1){
				if(p.hasPermission("AdminInv.Warp")){
					this.cfg.set("warps." + args[0].toLowerCase(), null);
					try {
						this.cfg.save(file);
						cs.sendMessage(Prefix + "§2Warp §6" + args[0].toLowerCase() + "§2 erfolgreich gelöscht");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}if(label.equalsIgnoreCase("warps")){
			String str = "Warp: §3";
			for(String warp : this.cfg.getConfigurationSection("warps").getKeys(false)){
				str += warp + ", ";
			}
			cs.sendMessage(Prefix + str);
		}
		return true;
	}

}
