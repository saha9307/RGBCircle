package ru.khasang.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Oleksandr on 28/11/2015.
 */
public class GameManager {

    public static final int MAX_CIRCLE = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int wight;
    private static int height;

    public GameManager(CanvasView canvasView, int _wight, int _height) {
        this.canvasView = canvasView;
        wight = _wight;
        height = _height;
        initMainCircle(_wight, _height);
        initEnemyCircle();
    }

    private void initEnemyCircle() {
        SimpleCircle mainCircleArea = mainCircle.getCirceArea();
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLE; i++){
            EnemyCircle circle;
            do {
                circle = EnemyCircle.getRandomCircle();
            }while (circle.isInteresect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCircleColor();
    }

    private void calculateAndSetCircleColor() {
        for (EnemyCircle circle: circles){
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    public static int getWidth() {
        return wight;
    }

    public static int getHeight() {
        return height;
    }

    public void initMainCircle(int wight, int height){
        mainCircle = new MainCircle(wight/2, height/2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);

        for (EnemyCircle circle: circles)
            canvasView.drawCircle(circle);
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainEventCircleWhenAt(x, y);
    }
}
