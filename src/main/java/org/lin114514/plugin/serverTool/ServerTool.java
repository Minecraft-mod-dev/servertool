package org.lin114514.plugin.serverTool;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerTool extends JavaPlugin {

    private static ServerTool instance;

    @Override
    public void onEnable() {
        instance=this;
        String[] lines = {
                "                                          _____              _ ",
                "        ___   ___  _ __ __   __ ___  _ __|_   _|___    ___  | |",
                "       / __| / _ \\| '__|\\ \\ / // _ \\| '__| | | / _ \\  / _ \\ | |",
                "       \\__ \\|  __/| |    \\ V /|  __/| |    | || (_) || (_) || |",
                "       |___/ \\___||_|     \\_/  \\___||_|    |_| \\___/  \\___/ |_|"
        };
        getLogger().info("\n");
        for(String s: lines){
            getLogger().info("I |" + s);
        }
        getLogger().info("ServerTool插件已启用！");
        Gift g = new Gift(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd,String label, String[] args) {
        String cmdNm = cmd.getName();
        if(cmdNm.equalsIgnoreCase("servertool")){
            PluginDescriptionFile desc = getDescription();
            sender.sendMessage("§a"+"=".repeat(30));
            sender.sendMessage("§9ServerTool插件帮助");
            sender.sendMessage("§a"+"=".repeat(30));
            // 命令信息
            desc.getCommands().forEach((comd, info) -> {
                sender.sendMessage("§6命令: /" + comd + "§r - §b" + info.get("description"));
            });
        }else if(cmdNm.equalsIgnoreCase("offlinehint")){
            if(args.length!=2){
                sender.sendMessage("§c参数太多/太少!");
                return false;
            }
            int mins = Integer.parseInt(args[0]);
            String msg = args[1];
            Message m = new Message();
            m.serverOffline(mins, msg);
        }else if(cmdNm.equalsIgnoreCase("joingroup")){
            if(args.length!=1){
                sender.sendMessage("§c参数太多/太少!");
                return false;
            }
            String groupUrl = args[0];
            Message m = new Message();
            m.joinGroup(groupUrl);
        }else if(cmdNm.equalsIgnoreCase("feedback")){
            if(args.length!=2){
                sender.sendMessage("§c参数太多/太少!");
                return false;
            }
            String type = args[0];
            String msg = args[1];
            Feedback.submit(type, msg);
        }
        return false;
    }
    @Override
    public void onDisable() {
        String[] lines = {
                "                                          _____              _ ",
                "        ___   ___  _ __ __   __ ___  _ __|_   _|___    ___  | |",
                "       / __| / _ \\| '__|\\ \\ / // _ \\| '__| | | / _ \\  / _ \\ | |",
                "       \\__ \\|  __/| |    \\ V /|  __/| |    | || (_) || (_) || |",
                "       |___/ \\___||_|     \\_/  \\___||_|    |_| \\___/  \\___/ |_|"
        };
        getLogger().info("\n");
        for(String s: lines){
            getLogger().info("I |" + s);
        }
        getLogger().info("ServerTool插件已禁用！");
    }
    public static ServerTool getInstance() {
        return instance;
    }
}
