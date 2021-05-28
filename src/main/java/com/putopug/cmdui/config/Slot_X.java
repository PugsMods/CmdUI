package com.putopug.cmdui.config;

/**
 * @author PugzAreCute
 */
public class Slot_X {
    private final String command;
    private final String item;
    private final Lore lore;
    private final String displayName;
    private final String permission_node;

    Slot_X(String command, String item, Lore lore, String displayName, String permission_node) {
        this.command = command;
        this.item = item;
        this.lore = lore;
        this.displayName = displayName;
        this.permission_node = permission_node;
    }

    public String getCommand() {
        return command;
    }

    public String getItem() {
        return item;
    }

    public Lore getLore() {
        return lore;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPermissionNode() {
        return permission_node;
    }
}

