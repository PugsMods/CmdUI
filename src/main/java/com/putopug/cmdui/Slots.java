package com.putopug.cmdui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Slots {
    public Map<String, Slot_X> getSlots() {
        return slots;
    }
    private Map<String,Slot_X> slots;
}
class Slot_X{
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

    private final String command;
    private final String item;
    private final Lore lore;
    private final String displayName;

    Slot_X(String command, String item, Lore lore, String displayName) {
        this.command = command;
        this.item = item;
        this.lore = lore;
        this.displayName=displayName;
    }
}
class Lore{
    public List<String> getLore() {
        List<String> lore = new ArrayList<String>();
        lore.add(line_1);
        lore.add(line_2);
        lore.add(line_3);
        return lore;
    }

    private String line_1;
    private String line_2;
    private String line_3;
}
