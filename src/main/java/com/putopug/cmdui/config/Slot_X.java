package com.putopug.cmdui.config;

/**
 * @author PugzAreCute
 */
public class Slot_X {
    private final String command;
    private final String item;
    private final Lore lore;
    private final String displayName;

    Slot_X(String command, String item, Lore lore, String displayName) {
        this.command = command;
        this.item = item;
        this.lore = lore;
        this.displayName = displayName;
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
}

