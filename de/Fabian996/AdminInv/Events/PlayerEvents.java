package de.Fabian996.AdminInv.Events;

import java.io.File;
import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.Fabian996.AdminInv.Main.AdminMain;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

@SuppressWarnings("deprecation")
public class PlayerEvents implements Listener {

	@SuppressWarnings("unused")
	private final AdminMain plugin;
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	private File file = new File("plugins/AdminInv", "config.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);
	
	public PlayerEvents(AdminMain plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if(AdminMain.afkPlayers.contains(p.getName())){
			AdminMain.afkPlayers.remove(p.getName());
			p.setDisplayName(p.getName());
			p.setCustomName(p.getName());
			p.setPlayerListName(p.getName());
			p.setCustomNameVisible(true);
			Bukkit.broadcastMessage(Prefix + p.getName() + "§f is now §aBack");
		}
	}	

	@EventHandler
	public void onChatMessage(PlayerChatEvent e){
		Player p = e.getPlayer();
		if(AdminMain.afkPlayers.contains(p.getName())){
			AdminMain.afkPlayers.remove(p.getName());
			p.setDisplayName(p.getName());
			p.setCustomName(p.getName());
			p.setPlayerListName(p.getName());
			p.setCustomNameVisible(true);
			Bukkit.broadcastMessage(Prefix + p.getName() + "§f is now §aBack");
		}
	}
	
	@EventHandler
	public void onJoinServer(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		//Tablist Message
		PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
		IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{'color': '" + cfg.getString("Header.Color") + "', 'text': '" + cfg.getString("Header.Text") + "'}");
		IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{'color': '" + cfg.getString("Footer.Color") + "', 'text': '" + cfg.getString("Footer.Text") + "'}");
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
	    	try{
		Field headerField = packet.getClass().getDeclaredField("a");
	        headerField.setAccessible(true);
	        headerField.set(packet, header);
	        headerField.setAccessible(!headerField.isAccessible());

	        Field footerField = packet.getClass().getDeclaredField("b");
	        footerField.setAccessible(true);
	        footerField.set(packet, footer);
	        footerField.setAccessible(!footerField.isAccessible());
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    	connection.sendPacket(packet);
	    
	    //Join Message
	    String JoinMessage = cfg.getString("Message.JoinMessage");
	    JoinMessage = JoinMessage.replace("%player%", p.getName());
	    e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', JoinMessage));
	    
	    //Title Message
	    String Title = ChatColor.translateAlternateColorCodes('&', cfg.getString("Title.Text"));
	    String SubTitle = ChatColor.translateAlternateColorCodes('&', cfg.getString("SubTitle.Text").replace("%player%", p.getDisplayName()));
	    sendTitle(p, Integer.valueOf(5), Integer.valueOf(80), Integer.valueOf(80), Title, SubTitle);
	}
	
	@EventHandler
	public void onQuitServer(PlayerQuitEvent e) throws EventException{
		Player p = e.getPlayer();
			String QuitMessage = cfg.getString("Message.QuitMessage");
			QuitMessage = QuitMessage.replace("%player%", p.getName());
			e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', QuitMessage));

	}
	
	public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle){
		PlayerConnection con = ((CraftPlayer)player).getHandle().playerConnection;
		PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
		con.sendPacket(packetPlayOutTimes);
		if(subtitle != null){
			subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
			IChatBaseComponent SubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
			PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, SubTitle);
			con.sendPacket(packetPlayOutSubTitle);
		}
		if(title != null){
			title = ChatColor.translateAlternateColorCodes('&', title);
			IChatBaseComponent Title = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
			PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, Title);
			con.sendPacket(packetPlayOutTitle);
		}
	}
}
