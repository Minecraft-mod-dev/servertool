package org.lin114514.plugin.serverTool;

import net.kyori.adventure.text.*;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class MessageLib {
    public static Component addText(String text, NamedTextColor color, TextDecoration decoration) {
        return Component.text(text).color(color).decorate(decoration);
    }
    public static ClickEvent openUrl(String url) {
        return ClickEvent.openUrl(url);
    }
    public static ClickEvent runCommand(String command) {
        return ClickEvent.runCommand(command);
    }
    public static HoverEvent showText(Component text) {
        return HoverEvent.showText(text);
    }
}
