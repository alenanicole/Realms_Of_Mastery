package main;

import entity.Entity;

public class CollisionManager {
    GamePanel panel;

    public CollisionManager(GamePanel panel){
        this.panel = panel;
    }

    public void checkTile(Entity entity){
        int entityWorldXLeft = entity.worldX + entity.collisionArea.x;
        int entityWorldXRight = entity.worldX + entity.collisionArea.x + entity.collisionArea.width;
        int entityWorldYTop = entity.worldY + entity.collisionArea.y;
        int entityWorldYBottom = entity.worldY + entity.collisionArea.y + entity.collisionArea.height;

        int entityLeftCol = entityWorldXLeft / panel.tileSize;
        int entityRightCol = entityWorldXRight / panel.tileSize;
        int entityTopRow = entityWorldYTop / panel.tileSize;
        int entityBottomRow = entityWorldYBottom / panel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityWorldYTop - entity.speed) / panel.tileSize;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (panel.tileManager.tile[tileNum1].collision || panel.tileManager.tile[tileNum2].collision) {
                    entity.collision = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityWorldYBottom + entity.speed) / panel.tileSize;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (panel.tileManager.tile[tileNum1].collision || panel.tileManager.tile[tileNum2].collision) {
                    entity.collision = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityWorldXLeft - entity.speed) / panel.tileSize;
                tileNum1 = panel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (panel.tileManager.tile[tileNum1].collision || panel.tileManager.tile[tileNum2].collision) {
                    entity.collision = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityWorldXRight + entity.speed) / panel.tileSize;
                tileNum1 = panel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = panel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (panel.tileManager.tile[tileNum1].collision || panel.tileManager.tile[tileNum2].collision) {
                    entity.collision = true;
                }
            }
        }
    }

    public int checkObject(Entity entity, boolean isPlayer){
            int index = 999;

            for(int i = 0; i < panel.obj.length; i++){
                if(panel.obj[i] != null){
                    entity.collisionArea.x = entity.worldX + entity.collisionArea.x;
                    entity.collisionArea.y = entity.worldY + entity.collisionArea.y;

                    panel.obj[i].collisionArea.x = panel.obj[i].worldX + panel.obj[i].collisionArea.x;
                    panel.obj[i].collisionArea.y = panel.obj[i].worldY + panel.obj[i].collisionArea.y;

                    switch (entity.direction) {
                        case "up" -> {
                            entity.collisionArea.y -= entity.speed;
                            if (entity.collisionArea.intersects(panel.obj[i].collisionArea)) {
                                if(panel.obj[i].collision){
                                    entity.collision = true;
                                }
                                if(isPlayer){
                                    index = i;
                                }
                            }
                        }
                        case "down" -> {
                            entity.collisionArea.y += entity.speed;
                            if (entity.collisionArea.intersects(panel.obj[i].collisionArea)) {
                                if(panel.obj[i].collision){
                                    entity.collision = true;
                                }
                                if(isPlayer){
                                    index = i;
                                }
                            }
                        }
                        case "left" -> {
                            entity.collisionArea.x -= entity.speed;
                            if (entity.collisionArea.intersects(panel.obj[i].collisionArea)) {
                                if(panel.obj[i].collision){
                                    entity.collision = true;
                                }
                                if(isPlayer){
                                    index = i;
                                }
                            }
                        }
                        case "right" -> {
                            entity.collisionArea.x += entity.speed;
                            if (entity.collisionArea.intersects(panel.obj[i].collisionArea)) {
                                if(panel.obj[i].collision){
                                    entity.collision = true;
                                }
                                if(isPlayer){
                                    index = i;
                                }
                            }
                        }
                    }

                    entity.collisionArea.x = entity.collisionAreaDefaultX;
                    entity.collisionArea.y = entity.collisionAreaDefaultY;

                    panel.obj[i].collisionArea.x = panel.obj[i].collisionAreaDefaultX;
                    panel.obj[i].collisionArea.y = panel.obj[i].collisionAreaDefaultY;
                }
            }

            return index;
    }

    public int checkItem(Entity entity, boolean isPlayer){
        int index = 999;

        for(int i = 0; i < panel.items.length; i++){
            if(panel.items[i] != null && !panel.items[i].found){
                entity.collisionArea.x = entity.worldX + entity.collisionArea.x;
                entity.collisionArea.y = entity.worldY + entity.collisionArea.y;

                panel.items[i].collisionArea.x = panel.items[i].worldX + panel.items[i].collisionArea.x;
                panel.items[i].collisionArea.y = panel.items[i].worldY + panel.items[i].collisionArea.y;

                switch (entity.direction) {
                    case "up" -> {
                        entity.collisionArea.y -= entity.speed;
                        if (entity.collisionArea.intersects(panel.items[i].collisionArea)) {
                            if(isPlayer){
                                index = i;
                            }
                        }
                    }
                    case "down" -> {
                        entity.collisionArea.y += entity.speed;
                        if (entity.collisionArea.intersects(panel.items[i].collisionArea)) {
                            if(isPlayer){
                                index = i;
                            }
                        }
                    }
                    case "left" -> {
                        entity.collisionArea.x -= entity.speed;
                        if (entity.collisionArea.intersects(panel.items[i].collisionArea)) {
                            if(isPlayer){
                                index = i;
                            }
                        }
                    }
                    case "right" -> {
                        entity.collisionArea.x += entity.speed;
                        if (entity.collisionArea.intersects(panel.items[i].collisionArea)) {
                            if(isPlayer){
                                index = i;
                            }
                        }
                    }
                }

                entity.collisionArea.x = entity.collisionAreaDefaultX;
                entity.collisionArea.y = entity.collisionAreaDefaultY;

                panel.items[i].collisionArea.x = panel.items[i].collisionAreaDefaultX;
                panel.items[i].collisionArea.y = panel.items[i].collisionAreaDefaultY;
            }
        }

        return index;
    }

    public int checkEntity(Entity entity, Entity[] targetArray){
        int index = 999;

        for(int i = 0; i < targetArray.length; i++){
            if(targetArray[i] != null && !targetArray[i].dead){
                entity.collisionArea.x = entity.worldX + entity.collisionArea.x;
                entity.collisionArea.y = entity.worldY + entity.collisionArea.y;

                targetArray[i].collisionArea.x = targetArray[i].worldX + targetArray[i].collisionArea.x;
                targetArray[i].collisionArea.y = targetArray[i].worldY + targetArray[i].collisionArea.y;

                switch (entity.direction) {
                    case "up" -> {
                        entity.collisionArea.y -= entity.speed;
                        if (entity.collisionArea.intersects(targetArray[i].collisionArea)) {
                            entity.collision = true;
                            index = i;
                        }
                    }
                    case "down" -> {
                        entity.collisionArea.y += entity.speed;
                        if (entity.collisionArea.intersects(targetArray[i].collisionArea)) {
                            entity.collision = true;
                            index = i;
                        }
                    }
                    case "left" -> {
                        entity.collisionArea.x -= entity.speed;
                        if (entity.collisionArea.intersects(targetArray[i].collisionArea)) {
                            entity.collision = true;
                            index = i;
                        }
                    }
                    case "right" -> {
                        entity.collisionArea.x += entity.speed;
                        if (entity.collisionArea.intersects(targetArray[i].collisionArea)) {
                            entity.collision = true;
                            index = i;
                        }
                    }
                }

                entity.collisionArea.x = entity.collisionAreaDefaultX;
                entity.collisionArea.y = entity.collisionAreaDefaultY;

                targetArray[i].collisionArea.x = targetArray[i].collisionAreaDefaultX;
                targetArray[i].collisionArea.y = targetArray[i].collisionAreaDefaultY;
            }
        }

        return index;
    }

    public void checkPlayer(Entity entity, boolean  isMonster, int idx){
        entity.collisionArea.x = entity.worldX + entity.collisionArea.x;
        entity.collisionArea.y = entity.worldY + entity.collisionArea.y;

        panel.player.collisionArea.x = panel.player.worldX + panel.player.collisionArea.x;
        panel.player.collisionArea.y = panel.player.worldY + panel.player.collisionArea.y;

        switch (entity.direction) {
            case "up" -> {
                entity.collisionArea.y -= entity.speed;
                if (entity.collisionArea.intersects(panel.player.collisionArea)) {
                    entity.collision = true;
                    if(isMonster){
                        panel.player.fightMonster(idx);
                    }
                }
            }
            case "down" -> {
                entity.collisionArea.y += entity.speed;
                if (entity.collisionArea.intersects(panel.player.collisionArea)) {
                    entity.collision = true;
                    if(isMonster){
                        panel.player.fightMonster(idx);
                    }
                }
            }
            case "left" -> {
                entity.collisionArea.x -= entity.speed;
                if (entity.collisionArea.intersects(panel.player.collisionArea)) {
                    entity.collision = true;
                    if(isMonster){
                        panel.player.fightMonster(idx);
                    }
                }
            }
            case "right" -> {
                entity.collisionArea.x += entity.speed;
                if (entity.collisionArea.intersects(panel.player.collisionArea)) {
                    entity.collision = true;
                    if(isMonster){
                        panel.player.fightMonster(idx);
                    }
                }
            }
        }

        entity.collisionArea.x = entity.collisionAreaDefaultX;
        entity.collisionArea.y = entity.collisionAreaDefaultY;

        panel.player.collisionArea.x = panel.player.collisionAreaDefaultX;
        panel.player.collisionArea.y = panel.player.collisionAreaDefaultY;
    }
}
