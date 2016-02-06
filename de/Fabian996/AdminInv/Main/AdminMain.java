package de.Fabian996.AdminInv.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import de.Fabian996.AdminInv.Commands.AdminHelp;
import de.Fabian996.AdminInv.Commands.BroadcastCMD;
import de.Fabian996.AdminInv.Commands.ClearChatCMD;
import de.Fabian996.AdminInv.Commands.GamemodeCMD;
import de.Fabian996.AdminInv.Commands.HelpCMD;
import de.Fabian996.AdminInv.Commands.InvseeCMD;
import de.Fabian996.AdminInv.Commands.KickCMD;
//import de.Fabian996.AdminInv.Commands.OntimeCMD;
import de.Fabian996.AdminInv.Commands.PingCMD;
import de.Fabian996.AdminInv.Commands.PlayerInfoCMD;
import de.Fabian996.AdminInv.Commands.ReNameCMD;
import de.Fabian996.AdminInv.Commands.ServerInfoCMD;
import de.Fabian996.AdminInv.Commands.SpawnCMD;
import de.Fabian996.AdminInv.Commands.TeamChatCMD;
import de.Fabian996.AdminInv.Commands.TeleportCMD;
//import de.Fabian996.AdminInv.Commands.TestCMD;
import de.Fabian996.AdminInv.Commands.VoteCMD;
import de.Fabian996.AdminInv.Commands.WarpCMD;
import de.Fabian996.AdminInv.Commands.afkCMD;
import de.Fabian996.AdminInv.Commands.msgCMD;
import de.Fabian996.AdminInv.Commands.remsgCMD;
import de.Fabian996.AdminInv.Events.PlayerEvents;
import de.Fabian996.AdminInv.Function.AdminFunction;
import de.Fabian996.AdminInv.Function.DifficultyFunction;
import de.Fabian996.AdminInv.Function.ExtraFunction;
import de.Fabian996.AdminInv.Function.GamemodeFunction;
import de.Fabian996.AdminInv.Function.ServerFunction;
import de.Fabian996.AdminInv.Function.WeatherFunction;
import de.Fabian996.AdminInv.GUI.AdminInventory;
import de.Fabian996.AdminInv.GUI.DiffiInv;
import de.Fabian996.AdminInv.GUI.ExtraInv;
import de.Fabian996.AdminInv.GUI.GamemodeInv;
import de.Fabian996.AdminInv.GUI.ServerInventory;
import de.Fabian996.AdminInv.GUI.WeatherInv;
import de.Fabian996.AdminInv.Handler.AdminItem;
import de.Fabian996.AdminInv.Handler.Ghast;
import de.Fabian996.AdminInv.Listener.Blocken;

public class AdminMain extends JavaPlugin{

	private static AdminMain instance;
	
	public static final ArrayList<String> afkPlayers = new ArrayList<>();
	
	
	
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
	    
	    //registerMySQLBank();
	    

	    //registerLibrary();  | coming soon
	    //registerLanguage(); | coming soon
	}

	//private void registerMySQLBank() {
		//if(getConfig().getBoolean("MySQL.Use_MySQL")){
		//	String hostname = getConfig().getString("MySQL.hostname");
		//	String portnmbr = getConfig().getString("MySQL.portnmbr");
		//	String database = getConfig().getString("MySQL.database");
		//	String username = getConfig().getString("MySQL.username");
		//	String password = getConfig().getString("MySQL.password");
			
	//	}
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
		
		getCommand("gm").setExecutor(new GamemodeCMD());
		
		//getCommand("test").setExecutor(new TestCMD());
		//getCommand("ontime").setExecutor(new OntimeCMD());
		//getCommand("home").setExecutor(new HomeCMD())
		//getCommand("report").setExecutor(new ReportCMD());
	}
	
	public void registerGUI(){
		getCommand("admin").setExecutor(new AdminInventory());
		getCommand("climate").setExecutor(new WeatherInv());
		getCommand("egm").setExecutor(new GamemodeInv());
		getCommand("diffis").setExecutor(new DiffiInv());
		getCommand("serverinv").setExecutor(new ServerInventory());
		getCommand("extra").setExecutor(new ExtraInv());
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
		
		getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);
		
	}
	
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
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
				p.sendMessage("§8[§4AdminInv§8]§r " + "§aConfig reloaded");
			}
		}
		return true;
	}
	
	public static AdminMain get() {
		return instance;
	}
}
