package dto;

public class Account {

    private Long id;
    private Integer amount;
    private Long userId;

    public Account() {
    }

    public Account(final Integer amount, final Long userId) {
        this.amount = amount;
        this.userId = userId;
    }

    public Account(final Long id, final Integer amount, final Long userId) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }
}
