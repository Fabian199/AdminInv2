package de.Fabian996.AdminInv.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import de.Fabian996.AdminInv.Commands.AdminHelp;
import de.Fabian996.AdminInv.Commands.BanCMD;
import de.Fabian996.AdminInv.Commands.BroadcastCMD;
import de.Fabian996.AdminInv.Commands.ClearChatCMD;
import de.Fabian996.AdminInv.Commands.GamemodeCMD;
import de.Fabian996.AdminInv.Commands.GlobalMute;
import de.Fabian996.AdminInv.Commands.HealCMD;
import de.Fabian996.AdminInv.Commands.HelpCMD;
import de.Fabian996.AdminInv.Commands.InvseeCMD;
import de.Fabian996.AdminInv.Commands.KickCMD;
import de.Fabian996.AdminInv.Commands.PingCMD;
import de.Fabian996.AdminInv.Commands.PlayerInfoCMD;
import de.Fabian996.AdminInv.Commands.ReNameCMD;
import de.Fabian996.AdminInv.Commands.ServerInfoCMD;
import de.Fabian996.AdminInv.Commands.SpawnCMD;
import de.Fabian996.AdminInv.Commands.TeamChatCMD;
import de.Fabian996.AdminInv.Commands.TeleportCMD;
import de.Fabian996.AdminInv.Commands.VoteCMD;
import de.Fabian996.AdminInv.Commands.WarpCMD;
import de.Fabian996.AdminInv.Commands.afkCMD;
import de.Fabian996.AdminInv.Commands.msgCMD;
import de.Fabian996.AdminInv.Commands.remsgCMD;
import de.Fabian996.AdminInv.Commands.unbanCMD;
import de.Fabian996.AdminInv.Commands.vanishCMD;
import de.Fabian996.AdminInv.Events.PlayerEvents;
import de.Fabian996.AdminInv.Function.AdminFunction;
import de.Fabian996.AdminInv.Function.DifficultyFunction;
import de.Fabian996.AdminInv.Function.ExtraFunction;
import de.Fabian996.AdminInv.Function.GamemodeFunction;
import de.Fabian996.AdminInv.Function.OnlinePlayerFunction;
import de.Fabian996.AdminInv.Function.ServerFunction;
import de.Fabian996.AdminInv.Function.WeatherFunction;
import de.Fabian996.AdminInv.GUI.AdminInventory;
import de.Fabian996.AdminInv.GUI.DiffiInv;
import de.Fabian996.AdminInv.GUI.ExtraInv;
import de.Fabian996.AdminInv.GUI.GamemodeInv;
import de.Fabian996.AdminInv.GUI.OnlinePlayerInv;
import de.Fabian996.AdminInv.GUI.ServerInventory;
import de.Fabian996.AdminInv.GUI.WeatherInv;
import de.Fabian996.AdminInv.Handler.AdminItem;
import de.Fabian996.AdminInv.Handler.Ghast;
import de.Fabian996.AdminInv.Listener.Blocken;

public class AdminMain extends JavaPlugin implements Listener,CommandExecutor{

	//Allgemein AdminInv
	private static AdminMain instance;
	
	AdminMain Main;
	
	public Server SERVER = getServer();
	public ConsoleCommandSender CONSOLE = this.SERVER.getConsoleSender();
	
	public static final ArrayList<String> afkPlayers = new ArrayList<>();
	public static final ArrayList<String> ServerTeam = new ArrayList<>();
	public ArrayList<String> blacklist = new ArrayList<String>();

	public static boolean Mute = false;
	
	//private MySQL mysql;
	
	//CommandSpy
	public static final ArrayList<String> CommandSpy = new ArrayList<>();
	
	public static final String AdminPrefix = "§8[§4AdminInv§8]§r ";
	public static final String SpyPrefix = "§8[§3AdminSpy§8]§r ";
	
	public String NoPerm = "You do have not Permission to do that";
	public String NoPlayer = "You must be a Player'";
	
	
	//Spy Command
	public String Spy = "§7>> §aNow you can see Commands";
	public String NoSpy = "§7>> §cYou can no longer see Commands";
	public String Correct_Use = "Use: §3/aspy ";
	
	Logger log = getLogger();
	
	public void onEnable(){
		System.out.println("[AdminInv] =================================");
		System.out.println("[AdminInv] Author: " + getDescription().getAuthors());
		System.out.println("[AdminInv] Version: v" + getDescription().getVersion());
		System.out.println("[AdminInv] Website: " + getDescription().getWebsite());
		System.out.println("[AdminInv] Status: Aktiviert");
		System.out.println("[AdminInv] =================================");
	    
	    
	    Metrics();
	    registerConfig();
	    registerReloadConfig();
	    registerCommands();
	    registerListener();
	    registerGUI();
	    registerBlacklist();
	//    ConnectMySQL();
	    
	    //registerLibrary();  | coming soon
	    //registerLanguage(); | coming soon
	}

	//public MySQL getMySQL(){
	//	   return mysql;
	//}
	
	//public void ConnectMySQL() {
	//	mysql = new MySQL("IP", "The database","Your username", "Your password");
	//	PreparedStatement statement = (PreparedStatement) mysql.prepareStatement("");
	//	mysql.update(statement);
	//}

	private void registerReloadConfig() {
		getCommand("areload").setExecutor(this);
	}

	public void registerCommands(){
		getCommand("ahelp").setExecutor(new AdminHelp());
		getCommand("phelp").setExecutor(new HelpCMD());
		getCommand("warp").setExecutor(new WarpCMD());

		getCommand("ghast").setExecutor(new AdminItem());
		getCommand("afk").setExecutor(new afkCMD(this));
		getCommand("ping").setExecutor(new PingCMD());
		getCommand("pinfo").setExecutor(new PlayerInfoCMD());
		getCommand("invsee").setExecutor(new InvseeCMD());
		getCommand("kick").setExecutor(new KickCMD());
		
		getCommand("br").setExecutor(new BroadcastCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		getCommand("vote").setExecutor(new VoteCMD());
		getCommand("sinfo").setExecutor(new ServerInfoCMD());
		
		getCommand("cc").setExecutor(new ClearChatCMD());
		getCommand("tc").setExecutor(new TeamChatCMD());
		getCommand("msg").setExecutor(new msgCMD());
		getCommand("r").setExecutor(new remsgCMD());
		getCommand("tp").setExecutor(new TeleportCMD());
		getCommand("rename").setExecutor(new ReNameCMD());
		
		getCommand("egm").setExecutor(new GamemodeCMD());
		getCommand("heal").setExecutor(new HealCMD());
		getCommand("aban").setExecutor(new BanCMD());
		getCommand("aunban").setExecutor(new unbanCMD());
		getCommand("aspy").setExecutor(this);
		getCommand("amute").setExecutor(new GlobalMute());
		
		getCommand("v").setExecutor(new vanishCMD(this));
	}
	
	public void registerGUI(){
		getCommand("admin").setExecutor(new AdminInventory());
		getCommand("climate").setExecutor(new WeatherInv());
		getCommand("egms").setExecutor(new GamemodeInv());
		getCommand("diffis").setExecutor(new DiffiInv());
		getCommand("serverinv").setExecutor(new ServerInventory());
		getCommand("extra").setExecutor(new ExtraInv());
		getCommand("onlinep").setExecutor(new OnlinePlayerInv());
	}
	
	public void registerListener(){
		getServer().getPluginManager().registerEvents(new Ghast(), this);
		getServer().getPluginManager().registerEvents(new Blocken(), this);
		
		getServer().getPluginManager().registerEvents(new AdminFunction(), this);
		getServer().getPluginManager().registerEvents(new WeatherFunction(), this);
		getServer().getPluginManager().registerEvents(new GamemodeFunction(), this);
		getServer().getPluginManager().registerEvents(new DifficultyFunction(), this);
		getServer().getPluginManager().registerEvents(new ServerFunction(), this);
		getServer().getPluginManager().registerEvents(new ExtraFunction(), this);
		getServer().getPluginManager().registerEvents(new OnlinePlayerFunction(), this);
		
		getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void registerBlacklist(){
		 File file = new File(this.getDataFolder(), "blacklist.txt");
		 if (!file.exists()) {
	            try {
	                getDataFolder().mkdir();
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        try {
	            Scanner s;
	            s = new Scanner(file);
	            while (s.hasNextLine())
	                blacklist.add(s.nextLine());
	 
	 
	            System.out.println("Loaded Blacklist " + blacklist.size() + " words.");
	            s.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}

	public void onDisable()	{
		System.out.println("[AdminInv] =================================");
		System.out.println("[AdminInv] Author: " + getDescription().getAuthors());
		System.out.println("[AdminInv] Version: v" + getDescription().getVersion());
		System.out.println("[AdminInv] Website: " + getDescription().getWebsite());
		System.out.println("[AdminInv] Status: Deaktiviert");
		System.out.println("[AdminInv] =================================");
	}

	public void  Metrics(){
		if (getConfig().getString("Metrics.enable") != null) {
            try {
                Metrics metrics = new Metrics(this);
                metrics.start();
                getLogger().info("Metrics succesfull" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                log.severe("[AdminInv] Metrics Failed to Start!");
            }
        } else {
            getLogger().info("Metrics wasn't started because it is disabled in the config!" + "\n");
        }
    }
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;	
		if(cmd.getName().equalsIgnoreCase("areload")){
			if(p.hasPermission("AdminInv.Reload") || p.hasPermission("AdminInv.*")){
				saveConfig();
				reloadConfig();
				p.sendMessage(AdminPrefix + "§aConfig reloaded");
			}
		}else if(cmd.getName().equalsIgnoreCase("aspy")){
			if(cs instanceof Player){
				if(cs.hasPermission("AdmminInv.AdminSpy")){
					if(!CommandSpy.contains(p.getName())){
						CommandSpy.add(p.getName());
						p.sendMessage(SpyPrefix + Spy);
					}else{
						CommandSpy.remove(p.getName());
						p.sendMessage(SpyPrefix + NoSpy);
					}
				}else{
					cs.sendMessage(SpyPrefix + NoPerm);
				}
			}else{
				cs.sendMessage(SpyPrefix + NoPlayer);
			}
		}else{
			cs.sendMessage(SpyPrefix + Correct_Use);
		}
		return true;
	}

	@EventHandler
	public void onSpy(PlayerCommandPreprocessEvent e){
		Player p = (Player)e.getPlayer();
		String cmd = e.getMessage();
		for(Player pl : Bukkit.getOnlinePlayers()){
			if((!CommandSpy.contains(pl.getName()))  || (p == pl)) continue;
			pl.sendMessage(SpyPrefix + "§7>> " + p.getName() + "§c:§6 " + cmd);
		}
		
	}
	
	public static AdminMain get() {
		return instance;
	}
}
