public class Train {
    private String trainNo;
    private Integer seatCount;

    public Train(String trainNo, Integer seatCount) {
        this.trainNo = trainNo;
        this.seatCount = seatCount;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
