package de.Fabian996.AdminInv.Commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ServerInfoCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	private File file = new File("plugins/AdminInv", "config.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("sinfo")){
			String Website = this.cfg.getString("serverinfo.website");
			String Teamspeak = this.cfg.getString("serverinfo.teamspeak");
			String Forum = this.cfg.getString("serverinfo.forum");
			
			p.sendMessage(Prefix + "§6+------------+§bServer Information§6+------------+");		
			p.sendMessage(Prefix + "§7Website: §2" + Website);
			p.sendMessage(Prefix + "§7Teamspeak: §2" + Teamspeak);
			p.sendMessage(Prefix + "§7Forum: §2" + Forum);
			p.sendMessage(Prefix + "§6+------------+§bServer Information§6+------------+");	
			return true;			
		}
		return false;
	}
}
