public class Ticket {
    private Integer ticketNo;
    private String departureStation;
    private String destinationStation;
    private Integer classCategory;
    private double price;
    private Train train;

    public Ticket(Integer ticketNo, String departureStation, String destinationStation, Integer classCategory, double price, Train train) {
        this.ticketNo = ticketNo;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.classCategory = classCategory;
        this.price = price;
        this.train = train;
    }

    public Integer getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Integer getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(Integer classCategory) {
        this.classCategory = classCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
