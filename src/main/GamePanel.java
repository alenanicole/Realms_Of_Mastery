package main;

import entity.Entity;
import entity.Player;
import item.StrengthPotion;
import item.SuperItem;
import object.SuperObject;
import tile.TileManager;
import ui.UI;
import weapon.Weapon;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    public final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 120;
    public final int maxWorldRow = 120;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public int gameState;
    public int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int selectState = 3;
    public final int inventoryState = 4;
    public final int useState = 5;
    public final int treasureState = 6;
    public final int fightState = 7;
    public final int tutorialState = 8;
    public final int deathState = 9;
    public final int startRunState = 10;
    public final int winState = 11;
    public final int statsState = 12;
    public final int achievementState = 13;

    public boolean inEncounter = false;
    public int numOfFight = 0;
    final int FPS = 60;

    Thread gameThread;

    KeyHandler keyHandler = new KeyHandler(this);
    public RandomNumGenerator randGen = new RandomNumGenerator();
    public Player player = new Player(this, keyHandler, "brown", "lightest", "green", "boy");
    public TileManager tileManager = new TileManager(this);
    public SuperObject obj[] = new SuperObject[20];
    public ObjectLoader objectLoader = new ObjectLoader(this);

    public SuperItem items[] = new SuperItem[26];
    public Weapon weapons[] = new Weapon[3];
    public ItemLoader itemLoader = new ItemLoader(this);
    public CollisionManager collisionManager = new CollisionManager(this);
    public QuestionManager questionManager = new QuestionManager(this);
    public TreasureManager treasureManager = new TreasureManager(this);
    public FightManager fightManager = new FightManager(this);

    public UI ui = new UI(this);
    public Entity monster[] = new Entity[20];
    public MonsterLoader monsterLoader = new MonsterLoader(this);
    public Entity npcs[] = new Entity[3];
    public NPCManager npcManager = new NPCManager(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(39, 53, 54));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setLayout(new FlowLayout());
    }

    public void setUpGame(){
        itemLoader.intializeStaticItems();
        questionManager.intitializeQuestions();
        npcManager.loadNPCs();
//        gameState = titleState;
//        gameState = startRunState;
//        gameState = achievementState;
        gameState = tutorialState;
    }

    public void reset() {
        tileManager.loadMap("/maps/Map.txt");
        objectLoader.unloadObjects();
        itemLoader.unloadItems();
        monsterLoader.unloadMonsters();
        npcManager.loadNPCs();
        player.currentHealth = player.maxHealth;

        player.worldX = 59 * tileSize;
        player.worldY = 59 * tileSize;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){
            update();
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void update() {

        if (gameState == playState || gameState == tutorialState) {
            player.update(0);

            if(gameState == playState) {
                for (int i = 1; i < monster.length; i++) {
                    if (monster[i] != null && !monster[i].dead) {
                        monster[i].update(i);
                    }
                }
            }
            if(gameState == tutorialState) {
                for (int i = 0; i < npcs.length; i++) {
                    if (npcs[i] != null) {
                        npcs[i].update(i);
                    }
                }
            }

        }

        if (((StrengthPotion) items[3]).strengthThread != null) {
            synchronized (((StrengthPotion) items[3]).strengthThread) {
                if (numOfFight <= 0) {
                    ((StrengthPotion) items[3]).strengthThread.notifyAll();
                }
            }
        }

    }

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);

        Graphics2D graphics2D = (Graphics2D)graphic;

        if(gameState == titleState){
            ui.draw(graphics2D);
        }else if(gameState == selectState){
            ui.draw(graphics2D);
        }else{
            tileManager.draw(graphics2D);

            for(int i = 0; i < obj.length; i++){
                if(obj[i] != null){
                    obj[i].draw(graphics2D, this);
                }
            }

            for(int i = 0; i < items.length; i++){
                if(items[i] != null && !items[i].found){
                    items[i].draw(graphics2D, this);
                }
            }

            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null && !monster[i].dead){
                    monster[i].draw(graphics2D, this);
                }
            }

            for(int i = 0; i < npcs.length; i++){
                if(npcs[i] != null){
                    npcs[i].draw(graphics2D, this);
                }
            }

            player.draw(graphics2D);

            ui.draw(graphics2D);
        }

        graphics2D.dispose();
    }
}
