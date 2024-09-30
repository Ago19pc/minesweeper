package it.ago19.minesweeper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Tile extends Button {

    private final int x;
    private final int y;
    private final boolean isBomb;
    private final float size;
    HelloController controller;

    public Tile(float side_size, int x, int y, boolean isBomb, HelloController controller) {
        super();
        this.size = side_size;
        this.isBomb = isBomb;
        this.x = x;
        this.y = y;
        this.controller = controller;
        this.setStyle("-fx-border-width: 1; -fx-border-color: black; -fx-background-color: grey");
        this.setMinSize(side_size, side_size);
        this.setMaxSize(side_size, side_size);
        this.setPrefSize(side_size, side_size);
        this.setOnMouseClicked(event -> {
            if (!isBomb) {
                this.setText(controller.getNearExplosives(this.x, this.y).toString());
            } else {
                this.setStyle("-fx-border-width: 1; -fx-border-color: black; -fx-background-color: red");
                controller.gameOver();
            }
        });
    }

    public int getX() { return x;}

    public int getY() { return y; }

    public boolean getIsBomb() { return isBomb; }

    public float getSize() { return size; }

    public void show() {
        if(!isBomb) {
            this.setText(controller.getNearExplosives(this.x, this.y).toString());
        } else {
            this.setStyle("-fx-border-width: 1; -fx-border-color: black; -fx-background-color: red");

        }


    }

}
