package no.woact.kveola13.application.database;

public class Match {

    private long id;
    private String player;
    private String result;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "player='" + player + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
