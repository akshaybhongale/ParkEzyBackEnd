package com.example.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ParkingSpot")
public class ParkingSpot {
    @Id
    private String parkingId;
    private String parkingName;
    private String address;
    private String info;
    private float ratings;
    private Location location;
    private String size;
    private float rate;
 /*   private SpotSchedule spotSchedule;*/
    private boolean isAvailable;
    private boolean isEvEnabled;

    public ParkingSpot(String parkingId, String parkingName, String address, String info, float ratings, Location location, String size, float rate, /*SpotSchedule spotSchedule, */boolean isAvailable, boolean isEvEnabled) {
        this.parkingId = parkingId;
        this.parkingName = parkingName;
        this.address = address;
        this.info = info;
        this.ratings = ratings;
        this.location = location;
        this.size = size;
        this.rate = rate;
   /*     this.spotSchedule = spotSchedule;*/
        this.isAvailable = isAvailable;
        this.isEvEnabled = isEvEnabled;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

 /*   public SpotSchedule getSpotSchedule() {
        return spotSchedule;
    }

    public void setSpotSchedule(SpotSchedule spotSchedule) {
        this.spotSchedule = spotSchedule;
    }
*/
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isEvEnabled() {
        return isEvEnabled;
    }

    public void setEvEnabled(boolean evEnabled) {
        isEvEnabled = evEnabled;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingId='" + parkingId + '\'' +
                ", parkingName='" + parkingName + '\'' +
                ", address='" + address + '\'' +
                ", info='" + info + '\'' +
                ", ratings=" + ratings +
                ", location=" + location +
                ", size='" + size + '\'' +
                ", rate=" + rate +
                ", isAvailable=" + isAvailable +
                ", isEvEnabled=" + isEvEnabled +
                '}';
    }
}
