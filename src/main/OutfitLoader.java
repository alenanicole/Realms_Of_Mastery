package main;

import outfit.*;

public class OutfitLoader {
    GamePanel panel;

    public OutfitLoader(GamePanel panel){
        this.panel = panel;
    }
    public void intializeStaticOutfits(){
        panel.outfits[0] = new Hat(panel);
        panel.outfits[1] = new Jacket(panel);
        panel.outfits[2] = new Suit(panel);
        panel.outfits[3] = new Checker(panel);
        panel.outfits[4] = new Ragtag(panel);
    }
}
