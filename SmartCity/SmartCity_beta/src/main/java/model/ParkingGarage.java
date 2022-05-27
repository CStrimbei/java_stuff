package model;

import java.util.Objects;
import java.util.Random;

public class ParkingGarage {
    private String location;
    private Double coordinates;
    private Random random = new Random();
    private int totalSpaces;
    private int occupiedSpaces; // = random.nextInt(totalSpaces)
    private int freeSpaces; // = totalSpaces - occupiedSpaces

    public ParkingGarage(String location, Double coordinates, int totalSpaces) {
        this.location = location;
        this.coordinates = coordinates;
        this.totalSpaces = totalSpaces;
        this.occupiedSpaces = random.nextInt(totalSpaces+1);
        this.freeSpaces = totalSpaces - occupiedSpaces;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double coordinates) {
        this.coordinates = coordinates;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getOccupiedSpaces() {
        return occupiedSpaces;
    }

    public void setOccupiedSpaces(int occupiedSpaces) {
        this.occupiedSpaces = occupiedSpaces;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingGarage that = (ParkingGarage) o;
        return totalSpaces == that.totalSpaces && occupiedSpaces == that.occupiedSpaces && freeSpaces == that.freeSpaces && Objects.equals(location, that.location) && Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, coordinates, totalSpaces, occupiedSpaces, freeSpaces);
    }

    @Override
    public String toString() {
        return "ParkingGarage{" +
                "location='" + location + '\'' +
                ", coordinates=" + coordinates +
                ", totalSpaces=" + totalSpaces +
                ", occupiedSpaces=" + occupiedSpaces +
                ", freeSpaces=" + freeSpaces +
                '}';
    }
}
