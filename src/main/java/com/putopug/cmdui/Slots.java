package com.putopug.cmdui;

import java.util.Map;

public class Slots {
    private Map<String,Slot_X> slots;
}
class Slot_X{
    private final String command;
    private final String item;
    private final Lore lore;
    private final String title;

    Slot_X(String command, String item, Lore lore, String title) {
        this.command = command;
        this.item = item;
        this.lore = lore;
        this.title = title;
    }
}
class Lore{
    private String line_1;
    private String line_2;
    private String line_3;
}
