package parking.system.guidance;

import java.util.*;

public class customerClassI {
    //public static int i;
    int id;
    private String name;
    private String plateNumber;
    private String carColor;
    private String brand;
    Date date = new Date();
    private double timeIn = date.getTime();
    //boolean isParked;
    
    customerClassI(){   
    }
    
    customerClassI(String name, String plateNumber, 
    String carColor , String brand, int id, double timeIn){ 
        this.id = id;
        this.name= name;
        this.plateNumber = plateNumber;
        this.carColor = carColor;
        this.brand= brand;
        this.timeIn = date.getTime();
    }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
        }

        public void setCarColor(String carColor) {
            this.carColor = carColor;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPlateNumber() {
            return plateNumber;
        }

        public String getCarColor() {
            return carColor;
        }

        public String getBrand() {
            return brand;
        }   
        
        public double getTimeIn() {
            return timeIn;
        } 
}

