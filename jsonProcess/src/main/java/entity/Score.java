package entity;

/**
 * create by Lee
 */

public class Score {
    private int score;
    private String title;
    private String desc;

    public Score(int score, String title, String desc) {
        this.score = score;
        this.title = title;
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
