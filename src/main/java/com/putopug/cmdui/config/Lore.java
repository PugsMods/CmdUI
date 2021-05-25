package com.putopug.cmdui.config;

import java.util.ArrayList;
import java.util.List;

public class Lore {
    private String line_1;
    private String line_2;
    private String line_3;

    public List<String> getLore() {
        List<String> lore = new ArrayList<String>();
        lore.add(line_1);
        lore.add(line_2);
        lore.add(line_3);
        return lore;
    }
}
