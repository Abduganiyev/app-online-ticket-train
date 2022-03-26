public class TrainSchedule {
    private Train train;
    private String from;
    private String to;
    public static Integer ticketCount;

    public TrainSchedule(Train train, String from, String to) {
        this.train = train;
        this.from = from;
        this.to = to;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
