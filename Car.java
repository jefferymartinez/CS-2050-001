public class Car {
    private String make;
    private String model;
    private int year;
    private double price;
	private String manufacturer;

   
    public Car(String make, String model, String manufacturer, int year, double price) {
        this.make = make;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
    }

    
	// Getters for the car details
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    
    public String getManaufactuer() {
    	return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }


    
    public String toString() {
        return make + " " + model + " (" + year + ") - $" + price;
    }
}
	
