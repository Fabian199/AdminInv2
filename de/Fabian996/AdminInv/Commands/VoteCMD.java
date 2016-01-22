package de.Fabian996.AdminInv.Commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class VoteCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	private File file = new File("plugins/AdminInv", "config.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("vote")){
			String Vote = this.cfg.getString("vote.message1");
			String Vote2 = this.cfg.getString("vote.message2");
			String Vote3 = this.cfg.getString("vote.message3");
			String Vote4 = this.cfg.getString("vote.message4");
			String Vote5 = this.cfg.getString("vote.message5");
			
			p.sendMessage(Prefix + "§6+---------------+§4§nVote Links§r§6+----------------+");		
			p.sendMessage(Prefix + "§7Vote 1: §b" + Vote);
			p.sendMessage(Prefix + "§7Vote 2: §b" + Vote2);
			p.sendMessage(Prefix + "§7Vote 3: §b" + Vote3);
			p.sendMessage(Prefix + "§7Vote 4: §b" + Vote4);
			p.sendMessage(Prefix + "§7Vote 5: §b" + Vote5);
			p.sendMessage(Prefix + "§6+---------------+§4§nVote Links§r§6+----------------+");	
			return true;
		}
		return true;
	}
}
