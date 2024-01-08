package main;

import outfit.*;

public class OutfitLoader {
    GamePanel panel;

    public OutfitLoader(GamePanel panel){
        this.panel = panel;
    }
    public void intializeStaticOutfits(){
        panel.outfits[0] = new Hat(panel);
        panel.outfits[1] = new Hat(panel);
        panel.outfits[2] = new Hat(panel);
        panel.outfits[3] = new Hat(panel);
        panel.outfits[4] = new Hat(panel);
    }
}
