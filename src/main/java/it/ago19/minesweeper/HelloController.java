package it.ago19.minesweeper;


import com.almasb.fxgl.core.math.Vec2;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.*;

public class HelloController {
    @FXML
    private Pane pane;
    private Map<Vec2, Tile> map = new HashMap<>();
    Random random = new Random();
    Button reset = new Button("Reset");
    Button show = new Button("Show");

    private void addTile(Tile tile){
        tile.setLayoutX(tile.getX() * tile.getSize());
        tile.setLayoutY(tile.getY() * tile.getSize());
        Vec2 coord = new Vec2(tile.getX() , tile.getY());
        map.put(coord, tile);
        pane.getChildren().add(tile);
    }

    public void setUp() {
        for (int i = 0; i < 20; i ++){
            for (int j = 0; j < 20; j ++){
                addTile(new Tile(40, j, i, random.nextBoolean() , this));
            }
        }
        reset.setOnMouseClicked(event -> {
            reset();
        });
        reset.setLayoutX(400);
        reset.setLayoutY(800);
        pane.getChildren().add(reset);

        show.setOnMouseClicked(event -> {
            for(Tile t : map.values()){
                t.show();
            }
        });
        show.setLayoutX(400);
        show.setLayoutY(850);
        pane.getChildren().add(show);

    }

    public Integer getNearExplosives(int x, int y) {
       return map.keySet().stream().filter(e -> e.distance(x, y) < 2 && map.get(e).getIsBomb()).toList().size();
    }

    public void gameOver() {
        for(Tile t : map.values()){
            t.setDisable(true);
        }
    }

    public void reset() {
        for(Tile t : map.values()){
            pane.getChildren().remove(t);
        }
        map.clear();
        for (int i = 0; i < 20; i ++){
            for (int j = 0; j < 20; j ++){
                addTile(new Tile(40, j, i, random.nextBoolean() , this));
            }
        }
    }
}