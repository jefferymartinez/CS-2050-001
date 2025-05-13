import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VendingMachine {
    private List<List<Car>> machine;  
    private Queue<Car> washQueue;     
    private int rows;
    private int cols;

    public VendingMachine(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.machine = new ArrayList<>();
        this.washQueue = new LinkedList<>();

       
        for (int i = 0; i < rows; i++) {
            List<Car> rowList = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                rowList.add(null); 
            }
            machine.add(rowList);
        }
    }


    public boolean addCar(Car car, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && machine.get(row).get(col) == null) {
            machine.get(row).set(col, car);
            System.out.println("Car added: " + car);
            return true;
        }
        System.out.println("Cannot add car at (" + row + ", " + col + "). Slot is already occupied or out of bounds.");
        return false;
    }

  
    public Car retrieveCar(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return machine.get(row).get(col);
        }
        return null;
    }

    
    public void sellCar(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            Car car = machine.get(row).get(col);
            if (car != null) {
                machine.get(row).set(col, null); 
                System.out.println("Car Sold: " + car);
            } else {
                System.out.println("No car found at Floor " + row + " Space " + col + ".");
            }
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void addCarToWashQueue(Car car) {
        washQueue.offer(car); 
        System.out.println("Car added to wash queue: " + car);
    }

   
    public void processCarWashQueue() {
        Car car = washQueue.poll(); 
        if (car != null) {
            System.out.println("Processing car for wash: " + car);
        } else {
            System.out.println("No cars in the wash queue.");
        }
    }

   
    public void displayVendingMachine() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Car car = machine.get(i).get(j);
                System.out.print(car != null ? car + "\t" : "[Empty]" + "\t");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) {
    	 String path = "C:\\Users\\jeffe\\eclipse-workspace\\Project01\\src";
        
          
             File file = new File(path + "\\cars01_02, cars02_02");
             try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             String line;
         }
        	 
         
         
         
        Scanner scanner = new Scanner(System.in);

        VendingMachine vendingMachine = new VendingMachine(3, 3); {

        while (true) {
            System.out.println("\n=== Car Vending Machine Menu ===");
            System.out.println("1. Load Car Data from File");
            System.out.println("2. Display Vending Machine");
            System.out.println("3. Retrieve a Car by Location (Floor & Space)");
            System.out.println("4. Print Sorted Inventory (Price)");
            System.out.println("5. Print Sorted Inventory (Year)");
            System.out.println("6. Search for Cars (Manufacturer & Type)");
            System.out.println("7. Add Car to Wash Queue");
            System.out.println("8. Process Car Wash Queue");
            System.out.println("9. Sell a Car");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                   
                    break;
                case 2:
                    vendingMachine.displayVendingMachine();
                    break;
                case 3:
                    System.out.print("Enter row and column to retrieve a car: ");
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    Car retrievedCar = vendingMachine.retrieveCar(row, col);
                    if (retrievedCar != null) {
                        System.out.println("Car retrieved: " + retrievedCar);
                    } else {
                        System.out.println("No car found at location (" + row + ", " + col + ")");
                    }
                    break;
                case 4:
                
                    break;
                case 5:
                
                    break;
                case 6:
              
                    break;
                case 7:
                  
                    System.out.print("Enter car manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter car model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter car year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter car price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter car type (Basic/Premium): ");
                    String type = scanner.nextLine();
                    Car carToWash = new Car(manufacturer, model, year, price, type);
                    vendingMachine.addCarToWashQueue(carToWash);
                    break;
                case 8:
            
                    vendingMachine.processCarWashQueue();
                    break;
                case 9:
                   
                    System.out.print("Enter row and column to sell a car: ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    vendingMachine.sellCar(row, col);
                    break;
                case 10:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
         
            
        }
    }
}

