package entity;

/**
 * create by Lee
 */

public class Expense {
    private int expense;
    private String title;
    private String desc;

    public Expense(int expense, String title, String desc) {
        this.expense = expense;
        this.title = title;
        this.desc = desc;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
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
