package org.lin114514.plugin.serverTool;

import net.kyori.adventure.text.*;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Message {
    // 服务器即将关闭提示
    public void serverOffline(int minutes, String why) {
        Component msg = Component.text()
                .append(MessageLib.addText("[公告]", NamedTextColor.RED, TextDecoration.BOLD))
                .append(MessageLib.addText("服务器即将在 " + minutes + " 分钟后关闭/重启，", NamedTextColor.GREEN, TextDecoration.BOLD))
                .append(MessageLib.addText("原因: " + why + " ", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .append(MessageLib.addText("造成不便请谅解!", NamedTextColor.GREEN, TextDecoration.BOLD))
                .build();

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(msg);
        }
    }

    // 加入服务器群组公告
    public void joinGroup(String groupUrl) {
        Component msg = Component.text()
                .append(MessageLib.addText("[群组]", NamedTextColor.BLUE, TextDecoration.BOLD))
                .append(MessageLib.addText("加入我们的", NamedTextColor.GREEN, TextDecoration.BOLD))
                .append(MessageLib.addText("群组", NamedTextColor.GREEN, TextDecoration.UNDERLINED).clickEvent(MessageLib.openUrl(groupUrl))
                        .hoverEvent(MessageLib.showText(MessageLib.addText("点击访问 " + groupUrl, NamedTextColor.GRAY, TextDecoration.UNDERLINED))))
                .append(MessageLib.addText("，与管理员共议建设服务器，与其他玩家交流!", NamedTextColor.GREEN, TextDecoration.BOLD))
                .build();

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(msg);
        }
    }
}
