package sanpe.plugin.tokumeiplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import net.md_5.bungee.api.ChatColor;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage("引数が不足しています。");
            return false;
        };

        try {
            switch (args[0]) {
                case "start":
                    Config.onWorking = true;
                    sender.sendMessage(ChatColor.GREEN+ "------50ちゃんねる------\n"
                    		+ "・チャットが匿名化されました。\n"
                    		+ "・チャットの最後に「as(半角スペース)名前」をつけてハンドルネームでチャットできます。\n"
                    		+ "    例 : 「こんにちは as KUN」→ 「<KUN> こんにちは」\n");
                    break;
                case "stop":
                    Config.onWorking = false;
                    sender.sendMessage("終了");
                    break;
                    };
        } catch (Exception e) {
            sender.sendMessage("引数が不正です。");
            return false;
        };
        return true;
    };
 }; 
