package sanpe.plugin.tokumeiplugin;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.Objects;
import java.util.regex.Pattern;

public class TokumeiPlugin extends JavaPlugin implements Listener {
	BukkitTask task = null;
	@Override
	public void onEnable() {
		//プラグイン有効化時の処理
		Objects.requireNonNull(getCommand("tokumei")).setExecutor(new CommandHandler());
		getLogger().info("有効化されました");
		getServer().getPluginManager().registerEvents(this,this);
	}
	
	@Override
	public void onDisable() {
		//プラグイン無効化時の処理
		getLogger().info("無効化されました");
	}
	
	public static String adjustChat(String chat) {
		String TokumeiName;
		String TokumeiMessage;
		String TokumeiChat;
		
		if (chat.contains("as ")) {
			Pattern pattern = Pattern.compile("as ");
			TokumeiName = pattern.split(chat)[1];
			TokumeiMessage = pattern.split(chat)[0];
		}
		else {
			TokumeiName = "名無しさん";
			TokumeiMessage = chat;
		}
		TokumeiChat = "<" + TokumeiName + "> " + TokumeiMessage;
		return TokumeiChat;
		
		
	}
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if (Config.onWorking) {
			event.setCancelled(true);
			String TokumeiChat;
			String chat = event.getMessage();
			
			TokumeiChat = adjustChat(chat);
			event.getPlayer().sendMessage(TokumeiChat);
		};
	}
}