package org.lin114514.plugin.serverTool;

import net.kyori.adventure.text.*;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class message {
    // 服务器即将关闭提示
    public void serverOffline(int minutes, String why) {
        Component msg = Component.text()
                .append(Component.text("[公告] ")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.BOLD))
                .append(Component.text("服务器即将在 " + minutes + " 分钟后关闭/重启，")
                        .color(NamedTextColor.GREEN))
                .append(Component.text("原因: " + why + " ")
                        .color(NamedTextColor.YELLOW))
                .append(Component.text("造成不便请谅解!")
                        .color(NamedTextColor.GREEN))
                .build();

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(msg);
        }
    }

    // 加入服务器群组公告
    public void joinGroup(String groupUrl) {
        Component msg = Component.text()
                .append(Component.text("[群组] ")
                        .color(NamedTextColor.BLUE)
                        .decorate(TextDecoration.BOLD))
                .append(Component.text("加入我们的")
                        .color(NamedTextColor.GREEN))
                .append(Component.text("群组")
                        .color(NamedTextColor.GREEN)
                        .decorate(TextDecoration.UNDERLINED)
                        .clickEvent(ClickEvent.openUrl(groupUrl))
                        .hoverEvent(HoverEvent.showText(
                                Component.text("点击访问 " + groupUrl)
                                        .color(NamedTextColor.GRAY))))
                .append(Component.text("，与管理员共议建设服务器，与其他玩家交流!")
                        .color(NamedTextColor.GREEN))
                .build();

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(msg);
        }
    }
}
