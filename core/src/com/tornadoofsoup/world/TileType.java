package com.tornadoofsoup.world;

import javax.activation.FileTypeMap;
import java.util.HashMap;

public enum TileType {

    GRASS(1, true, "Grass"),
    DIRT (2, true, "Dirt"),
    SKY  (3, false, "Sky"),
    STONE(4, true, "Stone"),
    CLOUD(5, false, "Cloud"),


    UNDEFINED(24, true, "UNDEFINED");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    private TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    private TileType(int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    private static HashMap<Integer, TileType> tileMap;

    static { //some weird thing that always runs on startup or something
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById(int id) {
        return tileMap.get(id);
    }
}
