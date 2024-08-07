package za.ac.cput.domain;
import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carID;
    @Embedded
    private CarInformation carInformation;
    @Embedded
    private CarInsurance carInsurance;
    private String rentalRate;
    private String availabilityStatus;
    @Lob
    @Column(length = 1024)
    private byte[] carPicture;
    protected Car() {
    }
    private Car(Builder builder) {
        this.carID = builder.carID;
        this.carInformation = builder.carInformation;
        this.carInsurance = builder.carInsurance;
        this.rentalRate = builder.rentalRate;
        this.availabilityStatus = builder.availabilityStatus;
        this.carPicture = builder.carPicture;
    }
    // Getters
    public Long getCarID() {
        return carID;
    }
    public CarInformation getCarInformation() {
        return carInformation;
    }
    public CarInsurance getCarInsurance() {
        return carInsurance;
    }

    public String getRentalRate() {
        return rentalRate;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public byte[] getCarPicture() {
        return carPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carID, car.carID) && Objects.equals(carInformation, car.carInformation) && Objects.equals(carInsurance, car.carInsurance) && Objects.equals(rentalRate, car.rentalRate) && Objects.equals(availabilityStatus, car.availabilityStatus) && Objects.equals(carPicture, car.carPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID, carInformation, carInsurance, rentalRate, availabilityStatus, carPicture);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carID +
                ", carInformation=" + carInformation +
                ", carInsurance=" + carInsurance +
                ", rentalRate='" + rentalRate + '\'' +
                ", availabilityStatus='" + availabilityStatus + '\'' +
                '}';
    }
    public static class Builder {
        private Long carID;
        private CarInformation carInformation;
        private CarInsurance carInsurance;
        private String rentalRate;
        private String availabilityStatus;
        private byte[] carPicture;
        public Builder setCarID(Long carID) {
            this.carID = carID;
            return this;
        }
        public Builder setCarInformation(CarInformation carInformation) {
            this.carInformation = carInformation;
            return this;
        }
        public Builder setCarInsurance(CarInsurance carInsurance) {
            this.carInsurance = carInsurance;
            return this;
        }
        public Builder setRentalRate(String rentalRate) {
            this.rentalRate = rentalRate;
            return this;
        }
        public Builder setAvailabilityStatus(String availabilityStatus) {
            this.availabilityStatus = availabilityStatus;
            return this;
        }
        public Builder setCarPicture(byte[] carPicture) {
            this.carPicture = carPicture;
            return this;
        }
        public Builder copyCar(Car car) {
            this.carID = car.carID;
            this.carInformation = car.carInformation;
            this.carInsurance = car.carInsurance;
            this.rentalRate = car.rentalRate;
            this.availabilityStatus = car.availabilityStatus;
            this.carPicture = car.carPicture;
            return this;
        }
        public Car buildCar() {
            return new Car(this);
        }
    }
}