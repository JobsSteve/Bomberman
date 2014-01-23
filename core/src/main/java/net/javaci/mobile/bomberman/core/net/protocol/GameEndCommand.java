package net.javaci.mobile.bomberman.core.net.protocol;

import org.json.JSONException;
import org.json.JSONObject;

public class GameEndCommand extends Command {
    public static enum GameEndReason {
        GAME_END, OWNER_LEFT
    }

    private GameEndReason reason;

    public String getWinner() {
        return winner;
    }

    private String winner;

    public static Command build(JSONObject json) {
        GameEndCommand command = new GameEndCommand();
        try {
            command.parseCommonFields(json);
            command.reason = GameEndReason.valueOf(json.getString("reason"));
            if (json.has("winner")) {
                command.winner = json.getString("winner");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return new UndefinedCommand(json.toString());

        }
        return command;
    }

    public GameEndReason getReason() {
        return reason;
    }

    public void setReason(GameEndReason reason) {
        this.reason = reason;
    }

    @Override
    protected void serializeCustomFields(JSONObject json) throws JSONException {
        json.put("reason", reason);
        if (this.winner != null) {
            json.put("winner", this.winner);
        }
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public int getCommand() {
        return Command.GAME_END;
    }
}
