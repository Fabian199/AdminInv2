package com.jimdo.Fabian996.AdminInv2.Listeners;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ScoreBoard implements Listener {
	
	public static AdminInv Main;
	public static Scoreboard board;
	private static Objective objective;
	public static Map<Integer, String> list = new HashMap<>();
	
	public File scoreboardfile = new File("plugins/AdminInv2/Einstellung", "Scoreboard.yml");
	public FileConfiguration scoreboardcfg = YamlConfiguration.loadConfiguration(scoreboardfile);

	public ScoreBoard(AdminInv main){
		Main = main;


	    String Title = scoreboardcfg.getString("Scoreboard.Title").replace("&", "§");
	    
	    String Line1 = scoreboardcfg.getString("Scoreboard.Line1").replace("&", "§");
	    String Line2 = scoreboardcfg.getString("Scoreboard.Line2").replace("&", "§");
	    String ph1 = scoreboardcfg.getString("Scoreboard.Placeholder1").replace("&", "§");
	    String Line3 = scoreboardcfg.getString("Scoreboard.Line3").replace("&", "§");
	    String Line4 = scoreboardcfg.getString("Scoreboard.Line4").replace("&", "§");
	    String Line5 = scoreboardcfg.getString("Scoreboard.Line5").replace("&", "§");
	    
	    list.put(Integer.valueOf(9), Line1);
	    list.put(Integer.valueOf(8), Line2);
	    list.put(Integer.valueOf(7), ph1);
	    list.put(Integer.valueOf(6), Line3);
	    list.put(Integer.valueOf(5), Line4);
	    list.put(Integer.valueOf(4), Line5);
	    
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    board = manager.getNewScoreboard();
	    objective = board.registerNewObjective("test", "dummy");
	    
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    
	    objective.setDisplayName(Title);
	    for (Map.Entry<Integer, String> option : list.entrySet())
	    {
	      Score score = objective.getScore((String)option.getValue());
	      score.setScore(((Integer)option.getKey()).intValue());
	    }
	    list.remove(Integer.valueOf(3));
	}
	
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
	    p.setScoreboard(board);
	}
	  
	public static Objective get(){
	    return objective;
	}
	  
	public static Scoreboard getScoreboard(){
		return board;
	}
}
