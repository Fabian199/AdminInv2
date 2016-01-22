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
import org.bukkit.event.Listener;

public class SpawnCMD implements CommandExecutor, Listener {
	
	private File file = new File("plugins/AdminInv", "spawn.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {	
		if(!(cs instanceof Player)){
			cs.sendMessage("Only Players Can Use Spawn Commands!");
			return true;
		}
		Player p = (Player)cs;
		if(label.equalsIgnoreCase("spawn")){
			World W = Bukkit.getServer().getWorld(this.cfg.getString("admin.world"));
			double X = this.cfg.getDouble("admin.X");
			double Y = this.cfg.getDouble("admin.Y");
			double Z = this.cfg.getDouble("admin.Z");
			
			p.teleport(new Location(W, X, Y, Z));
					
		}else if(label.equalsIgnoreCase("setspawn")){
			if(p.hasPermission("AdminInv.SetSpawn")){
				this.cfg.set("admin.world", p.getLocation().getWorld().getName());
				this.cfg.set("admin.X", Double.valueOf(p.getLocation().getBlockX()));
				this.cfg.set("admin.Y", Double.valueOf(p.getLocation().getBlockY()));
				this.cfg.set("admin.Z", Double.valueOf(p.getLocation().getBlockZ()));
				try {
					this.cfg.save(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				p.sendMessage(Prefix + "§2Spawn Location has been Set");
			}
		}
		return false;
	}

}
