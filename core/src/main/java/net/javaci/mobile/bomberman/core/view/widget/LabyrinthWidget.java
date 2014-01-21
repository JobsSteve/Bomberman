package net.javaci.mobile.bomberman.core.view.widget;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import net.javaci.mobile.bomberman.core.models.LabyrinthModel;
import net.peakgames.libgdx.stagebuilder.core.assets.AssetsInterface;
import net.peakgames.libgdx.stagebuilder.core.assets.ResolutionHelper;

public class LabyrinthWidget extends Actor {
    private LabyrinthModel labyrinthModel;
    private ResolutionHelper resolutionHelper;
    private AssetsInterface assets;
    private Vector2 gameAreaBounds;
    private Vector2 gameAreaPosition;
    private TextureRegion wall;
    private TextureRegion brick;

    public LabyrinthWidget(LabyrinthModel labyrinthModel, ResolutionHelper resolutionHelper, AssetsInterface assets) {
        this.labyrinthModel = labyrinthModel;
        this.resolutionHelper = resolutionHelper;
        this.assets = assets;
        this.gameAreaBounds = resolutionHelper.getGameAreaBounds();
        this.gameAreaPosition = resolutionHelper.getGameAreaPosition();
        TextureAtlas atlas = assets.getTextureAtlas("Common.atlas");
        wall = atlas.findRegion("wall");
        brick = atlas.findRegion("brick");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float numCols = 21;
        float numRows = 13;
        float width = gameAreaBounds.x / numCols;
        float height = gameAreaBounds.y / numRows;
        drawWalls(batch, numCols, numRows, width, height);
    }

    private void drawWalls(Batch batch, float numCols, float numRows, float width, float height) {
        for (int i = 0; i < labyrinthModel.getGrid().length; i++) {
            float x = width * i + gameAreaPosition.x;
            for (int j = 0; j < labyrinthModel.getGrid()[i].length; j++) {
                float y = j * height + gameAreaPosition.y;
                if (labyrinthModel.getGrid()[i][j] == LabyrinthModel.WALL) {
                    batch.draw(wall, x, y, width, height);
                } else if (labyrinthModel.getGrid()[i][j] == LabyrinthModel.BRICK) {
                    batch.draw(brick, x, y, width, height);
                }
            }
        }
    }

}
