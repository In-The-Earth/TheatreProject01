package sample;

public class Ticket {
    private String user;
    private String theatre ;
    private String time;
    private String chair;
    private String movie;

    public Ticket(String user, String theatre, String time, String chair, String movie) {
        this.user = user;
        this.theatre = theatre;
        this.time = time;
        this.chair = chair;
        this.movie = movie;
    }

    public String getChair() {
        return chair;
    }

    public String getMovie() {
        return movie;
    }

    public String getTheatre() {
        return theatre;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user+","+theatre+","+time+","+chair+","+movie;
    }
}
