package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import mapTileByTile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CharactersOperations {

    private LinkedList<Character> characters;

    private HashMap<String, Integer> characterPosEquivalence;

    public CharactersOperations(ArrayList<Integer> numCharacters, ArrayList<Integer> numCharacters2, int mapSize) {
        characters = new LinkedList<>();
        fillCharacters(numCharacters, "blue", mapSize);
        fillCharacters(numCharacters2, "red", mapSize);
        this.characterPosEquivalence = new HashMap<>();
        fillEquivalences();
    }

    private void fillCharacters(ArrayList<Integer> numCharacters, String team, int mapSize) {
        int cont = 0;
        int spawnPosX = 1;
        int spawnPosY = 1;
        switch (team) {
            case "blue":
                spawnPosX = 1;
                break;
            case "red":
                spawnPosX = mapSize;
                break;
        }
        for (int i : numCharacters) {
            for (int j = 0; j < i; j++) {
                switch (cont) {
                    case 0:
                        characters.add(new Character(new Texture("characters/" + team + "Magician.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                    case 1:
                        characters.add(new Character(new Texture("characters/" + team + "Archer.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                    case 2:
                        characters.add(new Character(new Texture("characters/" + team + "Hoplite.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                    case 3:
                        characters.add(new Character(new Texture("characters/medusa.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                    case 4:
                        characters.add(new Character(new Texture("characters/chimera.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                    case 5:
                        characters.add(new Character(new Texture("characters/hydra.png"), new Vector2(spawnPosX, spawnPosY), 2));
                        spawnPosY += 2;
                        break;
                }

                if (spawnPosY >= mapSize) {
                    spawnPosY = 1;
                    if (team.equals("blue"))
                        spawnPosX++;
                    else
                        spawnPosX--;
                }
            }
            cont++;
        }
    }

    private void fillEquivalences() {
        int cont = 0, mapX, mapY;
        for (Character character : characters) {
            mapX = (int) character.getCharMapPos().x;
            mapY = (int) character.getCharMapPos().y;
            characterPosEquivalence.put(mapX + "," + mapY, cont);
            cont++;
        }
    }

    public void moveCharacter(int mapX, int mapY, Character c) {
        c.setCharMapPos(new Vector2(mapX, mapY));
        float x = (mapX - mapY) * Tile.TILE_WIDTH / 2.0001f;
        float y = (mapY + mapX) * Tile.TILE_HEIGHT / 2f;
        c.setCharWorldPos(new Vector2(x, y));
    }

    public void updateHashMap(String charPos, String targetPos, int charArrayPos) {
        characterPosEquivalence.remove(charPos);
        characterPosEquivalence.put(targetPos, charArrayPos);
    }

    public LinkedList<Character> getCharacters() {
        return characters;
    }

    public HashMap<String, Integer> getCharacterPosEquivalence() {
        return characterPosEquivalence;
    }
}
