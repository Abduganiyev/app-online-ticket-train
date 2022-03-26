public class Order {
    private Integer orderId;
    private User user;
    private Ticket ticket;

    public Order(Integer orderId, User user, Ticket ticket) {
        this.orderId = orderId;
        this.user = user;
        this.ticket = ticket;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
