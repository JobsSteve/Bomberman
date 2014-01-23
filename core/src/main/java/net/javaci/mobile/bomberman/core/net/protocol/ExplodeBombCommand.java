package net.javaci.mobile.bomberman.core.net.protocol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExplodeBombCommand extends Command {
    private int gridX;
    private int gridY;
    private int id;
    private List<String> explodedPlayers = new ArrayList<String>();
    private List<Integer> explodedGhosts = new ArrayList<Integer>();

    public static Command build(JSONObject json) {
        ExplodeBombCommand command = new ExplodeBombCommand();
        try {
            command.parseCommonFields(json);
            command.gridX = json.getInt("gridX");
            command.gridY = json.getInt("gridY");
            command.id = json.getInt("id");
            {
                JSONArray jsonArray = json.getJSONArray("explodedPlayers");
                if (jsonArray != null) {
                    int length = jsonArray.length();
                    for (int i=0; i<length; i++) {
                        command.explodedPlayers.add(jsonArray.getString(i));
                    }
                }
            }
            {
                JSONArray jsonArray = json.getJSONArray("explodedGhosts");
                if (jsonArray != null) {
                    int length = jsonArray.length();
                    for (int i=0; i<length; i++) {
                        command.explodedGhosts.add(jsonArray.getInt(i));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return new UndefinedCommand(json.toString());

        }
        return command;
    }

    public int getGridX() {
        return gridX;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    protected void serializeCustomFields(JSONObject json) throws JSONException {
        json.put("gridX", gridX);
        json.put("gridY", gridY);
        json.put("id", id);
        {
            JSONArray array = new JSONArray();
            for (String player : this.explodedPlayers) {
                array.put(player);;
            }
            json.put("explodedPlayers", array);
        }
        {
            JSONArray jsonArray = new JSONArray();
            for (Integer ghostId : explodedGhosts) {
                jsonArray.put(ghostId);
            }
            json.put("explodedGhosts", jsonArray);
        }
    }

    @Override
    public int getCommand() {
        return EXPLODE_BOMB;
    }


    public List<String> getExplodedPlayers() {
        return explodedPlayers;
    }

    public void setExplodedPlayers(List<String> explodedPlayers) {
        this.explodedPlayers = explodedPlayers;
    }

    public List<Integer> getExplodedGhosts() {
        return explodedGhosts;
    }

    public void setExplodedGhosts(List<Integer> explodedGhosts) {
        this.explodedGhosts = explodedGhosts;
    }
}
