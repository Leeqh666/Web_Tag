package entity;

import java.util.List;

/**
 * create by Lee
 */

public class Review {
    List<ReviewPic> reviewPics;
    List<ExtInfo> extInfoList;
    List<Expense> expenseList;
    List<Integer> reviewIndexes;
    List<Score> scoreList;

    public Review(List<ReviewPic> reviewPics, List<ExtInfo> extInfoList, List<Expense> expenseList, List<Integer> reviewIndexes, List<Score> scoreList) {
        this.reviewPics = reviewPics;
        this.extInfoList = extInfoList;
        this.expenseList = expenseList;
        this.reviewIndexes = reviewIndexes;
        this.scoreList = scoreList;
    }

    public List<ReviewPic> getReviewPics() {
        return reviewPics;
    }

    public void setReviewPics(List<ReviewPic> reviewPics) {
        this.reviewPics = reviewPics;
    }

    public List<ExtInfo> getExtInfoList() {
        return extInfoList;
    }

    public void setExtInfoList(List<ExtInfo> extInfoList) {
        this.extInfoList = extInfoList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public List<Integer> getReviewIndexes() {
        return reviewIndexes;
    }

    public void setReviewIndexes(List<Integer> reviewIndexes) {
        this.reviewIndexes = reviewIndexes;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
