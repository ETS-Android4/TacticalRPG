package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import mapTileByTile.Tile;

public class Character {
    private TextureRegion t;
    private Vector2 charMapPos;

    private Vector2 charWorldPos;
    private Integer movementCapacity;

    public Character() {
        this.t = new TextureRegion(new Texture("character2.png"), 32, 32);
        this.charMapPos = new Vector2(4, 3);
        this.charWorldPos = calculateWorldPos(charMapPos);
        this.movementCapacity = 2;
    }

    public void render(SpriteBatch batch) {
        batch.draw(t, charWorldPos.x, charWorldPos.y);
    }

    private Vector2 calculateWorldPos(Vector2 charMapPos) {
        float x = (charMapPos.x - charMapPos.y) * Tile.TILE_WIDTH / 2.0001f;
        float y = (charMapPos.y + charMapPos.x) * Tile.TILE_HEIGHT / 2f;
        return new Vector2(x, y);
    }

    public Vector2 getCharMapPos() {
        return charMapPos;
    }

    public Integer getMovementCapacity() {
        return movementCapacity;
    }

    public void setMovementCapacity(Integer movementCapacity) {
        this.movementCapacity = movementCapacity;
    }

    public void setCharMapPos(Vector2 charMapPos) {
        this.charMapPos = charMapPos;
    }

    public void setCharWorldPos(Vector2 charWorldPos) {
        this.charWorldPos = charWorldPos;
    }
}