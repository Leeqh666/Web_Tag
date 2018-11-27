package entity;

/**
 * create by Lee
 */

public class ReviewPic {
    private String picId;
    private String url;
    private int status;

    public ReviewPic(String picId, String url, int status) {
        this.picId = picId;
        this.url = url;
        this.status = status;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
