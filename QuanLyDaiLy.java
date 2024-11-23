import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Lớp Car với tính đóng gói
class Car {
    private String id;
    private String model;
    private String manufacturer;
    private int year;
    private double price;

    public Car(String id, String model, String manufacturer, int year, double price) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
    }

    //Getter và Setter cho các thuộc tính
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayCarInfo() {
        System.out.printf("| %-4s | %-12s | %-15s | %-4d | %-10.2f |\n", id, model, manufacturer, year, price);
    }
}

//Lớp Customer với tính đóng gói
class Customer {
    private String customerId;
    private String name;
    private String address;
    private String phoneNumber;

    public Customer(String customerId, String name, String address, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter cho các thuộc tính
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Phương thức hiển thị thông tin khách hàng
    public void displayCustomerInfo() {
        System.out.printf("| %-5s | %-20s | %-25s | %-15s |\n", customerId, name, address, phoneNumber);
    }

    // Thêm phương thức getId() cho đơn giản (nếu cần thiết)
    public String getId() {
        return customerId;
    }
}

//Lớp Transaction với tính đóng gói
class Transaction {
    private Car car;
    private Customer customer;
    private String date;
    private double totalPrice;

    public Transaction(Car car, Customer customer, String date) {
        this.car = car;
        this.customer = customer;
        this.date = date;
        this.totalPrice = car.getPrice();
    }
    //Hiển thị thông tin giao dịch
    public void displayTransactionInfo() {
        System.out.println("Transaction Date: " + date);
        car.displayCarInfo();
        customer.displayCustomerInfo();
        System.out.println("Total Price: " + totalPrice);
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }
}

//Lớp Dealership với tính đóng gói
class Dealership {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Transaction> transactions = new ArrayList<>();
    

    public Dealership() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();

        //Thêm sẵn các ô tô vào danh sách khi khởi tạo
        cars.add(new Car("1", "911", "Porsche", 2020, 150000));
        cars.add(new Car("2", "R8", "Audi", 2021, 170000));
        cars.add(new Car("3", "Aventador", "Lamborghini", 2022, 300000));
        cars.add(new Car("4", "DB11", "Aston Martin", 2020, 205000));
        cars.add(new Car("5", "Veyron", "Bugatti", 2021, 2500000));
        cars.add(new Car("6", "488 GTB", "Ferrari", 2021, 330000));
        cars.add(new Car("7", "M8", "BMW", 2022, 130000));
        cars.add(new Car("8", "Continental GT", "Bentley", 2022, 220000));
        cars.add(new Car("9", "Panamera", "Porsche", 2021, 120000));
        cars.add(new Car("10", "Ghost", "Rolls-Royce", 2021, 350000));
        cars.add(new Car("11", "S-Class", "Mercedes-Benz", 2022, 150000));
        cars.add(new Car("12", "R8 V10", "Audi", 2020, 160000));
        cars.add(new Car("13", "LaFerrari", "Ferrari", 2022, 1500000));
        
        // Thêm khách hàng mặc định vào danh sách khi khởi tạo
        customers.add(new Customer("1", "An", "HN", "091"));
        customers.add(new Customer("2", "Bao", "Nam Dinh", "038"));
        customers.add(new Customer("3", "Hai", "Phu Tho", "082"));
    }
    
    //Getter cho danh sách ô tô
    public List<Car> getCars() {
        return cars;
    }

    //Getter cho danh sách khách hàng
    public List<Customer> getCustomers() {
        return customers;
    }

    //Getter cho danh sách giao dịch
    public List<Transaction> getTransactions() {
        return transactions;
    }

    //Cập nhật thông tin xe
    public void updateCarInfo(String carId) {
        Car carToUpdate = null;
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                carToUpdate = car;
                break;
            }
        }

        if (carToUpdate != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap model moi: ");
            carToUpdate.setModel(scanner.nextLine());
            System.out.print("Nhap nha san xuat moi: ");
            carToUpdate.setManufacturer(scanner.nextLine());
            System.out.print("Nhap nam san xuat moi: ");
            carToUpdate.setYear(scanner.nextInt());
            System.out.print("Nhap gia moi: ");
            carToUpdate.setPrice(scanner.nextDouble());
            System.out.println("Thong tin o to da duoc cap nhat.");
        } else {
            System.out.println("Khong tim thay o to voi ID da nhap.");
        }
    }
    
    //Cập nhật thông tin giao dịch
    public void updateTransaction(String carId) {
        Transaction transactionToUpdate = null;
        for (Transaction transaction : transactions) {
            if (transaction.getCar().getId().equals(carId)) {
                transactionToUpdate = transaction;
                break;
            }
        }

        if (transactionToUpdate != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap ngay giao dich moi: ");
            String newDate = scanner.nextLine();
            transactionToUpdate = new Transaction(transactionToUpdate.getCar(), transactionToUpdate.getCustomer(), newDate);
            System.out.println("Thong tin giao dich da duoc cap nhat.");
        } else {
            System.out.println("Khong tim thay giao dich voi ID o to da nhap.");
        }
    }

    // Phương thức tìm kiếm khách hàng theo ID
    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer; // Trả về khách hàng nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy khách hàng
    }
    
    // Phuong thuc cap nhat thong tin khach hang
    public void updateCustomerInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ID khach hang can cap nhat: ");
        String customerId = scanner.nextLine();

        // Tim khach hang theo ID
        Customer customerToUpdate = findCustomerById(customerId);
        if (customerToUpdate != null) {
            // Hien thi thong tin hien tai cua khach hang
            System.out.println("Thong tin hien tai cua khach hang: ");
            customerToUpdate.displayCustomerInfo();

            // Nhap thong tin moi de cap nhat
            System.out.print("Nhap ten moi cho khach hang: ");
            String newName = scanner.nextLine();
            customerToUpdate.setName(newName);

            System.out.print("Nhap dia chi moi cho khach hang: ");
            String newAddress = scanner.nextLine();
            customerToUpdate.setAddress(newAddress);

            System.out.print("Nhap so dien thoai moi cho khach hang: ");
            String newPhoneNumber = scanner.nextLine();
            customerToUpdate.setPhoneNumber(newPhoneNumber);

            // Cap nhat thong tin cho khach hang
            System.out.println("Cap nhat thanh cong. Thong tin moi cua khach hang: ");
            customerToUpdate.displayCustomerInfo();
        } else {
            System.out.println("Khong tim thay khach hang voi ID: " + customerId);
        }
    }


    // Hiển thị tất cả giao dịch
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Khong co giao dich nao.");
        } else {
            for (Transaction transaction : transactions) {
                transaction.displayTransactionInfo();
            }
        }
    }

    //Tính tổng doanh thu từ các giao dịch
    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Transaction transaction : transactions) {
            totalRevenue += transaction.getCar().getPrice();
        }
        return totalRevenue;
    }

    //Tìm kiếm ô tô theo ID hoặc tên model
    public Car searchCar(String searchTerm) {
        for (Car car : cars) {
            if (car.getId().equals(searchTerm) || car.getModel().equalsIgnoreCase(searchTerm)) {
                return car;
            }
        }
        return null;
    }

    //Tìm kiếm khách hàng theo ID hoặc tên
    public Customer searchCustomer(String searchTerm) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(searchTerm) || customer.getName().equalsIgnoreCase(searchTerm)) {
                return customer;
            }
        }
        return null;
    }

    //Xóa ô tô khỏi danh sách
    public void removeCar(String carId) {
        cars.removeIf(car -> car.getId().equals(carId));
        System.out.println("O to da duoc xoa.");
    }

    //Xóa khách hàng khỏi danh sách
    public void removeCustomer(String customerId) {
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
        System.out.println("Khach hang da duoc xoa.");
    }

    //Lọc ô tô theo nhà sản xuất
    public void filterCarsByManufacturer(String manufacturer) {
        System.out.println("O to theo nha san xuat: " + manufacturer);
        for (Car car : cars) {
            if (car.getManufacturer().equalsIgnoreCase(manufacturer)) {
                car.displayCarInfo();
            }
        }
    }

    //Lọc ô tô theo năm sản xuất
    public void filterCarsByYear(int year) {
        System.out.println("O to theo nam san xuat: " + year);
        for (Car car : cars) {
            if (car.getYear() == year) {
                car.displayCarInfo();
            }
        }
    }

    //Lọc ô tô theo giá chính xác
    public void filterCarsByPrice(double price) {
        System.out.println("O to co gia: " + price);
        boolean found = false;
        for (Car car : cars) {
            if (car.getPrice() == price) {
                car.displayCarInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co xe nao co gia: " + price);
        }
    }



    //Hiển thị chi tiết giao dịch theo ID xe
    public void displayTransactionByCarId(String carId) {
        for (Transaction transaction : transactions) {
            if (transaction.getCar().getId().equals(carId)) {
                transaction.displayTransactionInfo();
                return;
            }
        }
        System.out.println("Khong tim thay giao dich cho o to voi ID da nhap.");
    }

    // Hiển thị danh sách giao dịch theo ID khách hàng
    public void displayTransactionsByCustomer(String customerId) {
       System.out.println("Danh sach giao dich cho khach hang " + customerId + ":");
       boolean foundTransaction = false;  // Biến cờ để kiểm tra có giao dịch hay không

       // Duyệt qua danh sách giao dịch và tìm giao dịch của khách hàng theo ID
       for (Transaction transaction : transactions) {
           if (transaction.getCustomer().getCustomerId().equals(customerId)) {
               transaction.displayTransactionInfo();
               foundTransaction = true;  // Đã tìm thấy giao dịch, cập nhật cờ
           }
       }

       // Nếu không có giao dịch nào, thông báo cho người dùng
       if (!foundTransaction) {
           System.out.println("Khong co giao dich nao cho khach hang ID: " + customerId);
       }
   }

    //Xuất báo cáo giao dịch ra file
    public void exportTransactionsToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.getCar().getId() + "," + transaction.getCustomer().getCustomerId() + "," + transaction.getCar().getPrice() + "\n");
            }
            System.out.println("Da xuat giao dich ra file " + fileName);
        } catch (IOException e) {
            System.out.println("Loi khi xuat file: " + e.getMessage());
        }
    }

    //Hiển thị tất cả ô tô
    public void displayAllCars() {
        System.out.printf("| %-4s | %-12s | %-15s | %-4s | %-10s |\n", "ID", "Model", "Manufacturer", "Year", "Price");
        for (Car car : cars) {
            car.displayCarInfo();
        }
    }

    //Hiển thị tất cả khách hàng
    public void displayAllCustomers() {
        System.out.printf("| %-5s | %-20s | %-25s | %-15s |\n", "ID", "Name", "Address", "Phone");
        for (Customer customer : customers) {
            customer.displayCustomerInfo();
        }
    }

    //Thêm khách hàng
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //Thêm giao dịch
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}

//Lớp chính
public class QuanLyDaiLy {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- Quan Ly Dai Ly -----");
            System.out.println("1. Them o to hoac them khach hang");
            System.out.println("2. Them giao dich");
            System.out.println("3. Cap nhat thong tin giao dich");
            System.out.println("4. Hien thi tat ca o to");
            System.out.println("5. Hien thi tat ca giao dich");
            System.out.println("6. Hien thi tat ca khach hang");
            System.out.println("7. Cap nhat thong tin o to");
            System.out.println("8. Cap nhat thong tin khach hang");
            System.out.println("9. Tim kiem o to");
            System.out.println("10. Tim kiem khach hang");
            System.out.println("11. Xoa o to");
            System.out.println("12. Xoa khach hang");
            System.out.println("13. Loc o to theo nha san xuat");
            System.out.println("14. Loc o to theo nam");
            System.out.println("15. Loc o to theo gia");
            System.out.println("16. Hien thi giao dich theo ID xe");
            System.out.println("17. Hien thi giao dich theo ID khach hang");
            System.out.println("18. Xuat bao cao giao dich ra file");
            System.out.println("19. Thoat");

            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("1. Them o to");
                    System.out.println("2. Them khach hang");
                    System.out.print("Nhap lua chon: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    if (subChoice == 1) {
                        //Thêm ô tô
                        System.out.print("Nhap ID o to: ");
                        String carId = scanner.nextLine();
                        System.out.print("Nhap model: ");
                        String model = scanner.nextLine();
                        System.out.print("Nhap nha san xuat: ");
                        String manufacturer = scanner.nextLine();
                        System.out.print("Nhap nam san xuat: ");
                        int year = scanner.nextInt();
                        System.out.print("Nhap gia: ");
                        double price = scanner.nextDouble();
                        Car car = new Car(carId, model, manufacturer, year, price);
                        dealership.getCars().add(car);
                        System.out.println("O to da duoc them.");
                    } else if (subChoice == 2) {
                        //Thêm khách hàng
                        System.out.print("Nhap ID khach hang: ");
                        String customerId = scanner.nextLine();
                        System.out.print("Nhap ten khach hang: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhap dia chi: ");
                        String address = scanner.nextLine();
                        System.out.print("Nhap so dien thoai: ");
                        String phoneNumber = scanner.nextLine();
                        Customer customer = new Customer(customerId, name, address, phoneNumber);
                        dealership.addCustomer(customer);
                        System.out.println("Khach hang da duoc them.");
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;


                case 2:
                    //Thêm giao dịch
                    System.out.print("Nhap ID o to: ");
                    String carIdForTransaction = scanner.nextLine();
                    System.out.print("Nhap ID khach hang: ");
                    String customerIdForTransaction = scanner.nextLine();
                    System.out.print("Nhap ngay giao dich (dd/MM/yyyy): ");
                    String date = scanner.nextLine();

                    Car selectedCar = dealership.searchCar(carIdForTransaction);
                    Customer selectedCustomer = dealership.searchCustomer(customerIdForTransaction);

                    if (selectedCar != null && selectedCustomer != null) {
                        Transaction transaction = new Transaction(selectedCar, selectedCustomer, date);
                        dealership.addTransaction(transaction);
                        System.out.println("Giao dich da duoc tao.");
                    } else {
                        System.out.println("O to hoac khach hang khong ton tai.");
                    }
                    break;

                case 3:
                    //Cập nhật thông tin giao dịch
                    System.out.print("Nhap ID o to can cap nhat: ");
                    String carIdToUpdate = scanner.nextLine();
                    dealership.updateTransaction(carIdToUpdate);
                    break;

                case 4:
                    //Hiển thị tất cả ô tô
                    dealership.displayAllCars();
                    break;
                    
                case 5:
                    //Hiển thị tất cả giao dịch
                    dealership.displayAllTransactions();
                    break;

                case 6:
                    //Hiển thị tất cả khách hàng
                    dealership.displayAllCustomers();
                    break;

                case 7:
                    //Đổi thông tin ô tô
                    System.out.print("Nhap ID o to can doi thong tin: ");
                    String carIdToUpdateInfo = scanner.nextLine();
                    dealership.updateCarInfo(carIdToUpdateInfo);
                    break;

                case 8:
                    //Đổi thông tin khách hàng
                    dealership.updateCustomerInfo();
                    break;

                case 9:
                    //Tìm kiếm ô tô
                    System.out.print("Nhap ID hoac ten model o to: ");
                    String searchCarTerm = scanner.nextLine();
                    Car foundCar = dealership.searchCar(searchCarTerm);
                    if (foundCar != null) {
                        foundCar.displayCarInfo();
                    } else {
                        System.out.println("Khong tim thay o to.");
                    }
                    break;

                case 10:
                    //Tìm kiếm khách hàng
                    System.out.print("Nhap ID hoac ten khach hang: ");
                    String searchCustomerTerm = scanner.nextLine();
                    Customer foundCustomer = dealership.searchCustomer(searchCustomerTerm);
                    if (foundCustomer != null) {
                        foundCustomer.displayCustomerInfo();
                    } else {
                        System.out.println("Khong tim thay khach hang.");
                    }
                    break;

                case 11:
                    //Xóa ô tô
                    System.out.print("Nhap ID o to can xoa: ");
                    String carIdToRemove = scanner.nextLine();
                    dealership.removeCar(carIdToRemove);
                    break;

                case 12:
                    //Xóa khách hàng
                    System.out.print("Nhap ID khach hang can xoa: ");
                    String customerIdToRemove = scanner.nextLine();
                    dealership.removeCustomer(customerIdToRemove);
                    break;

                case 13:
                    //Lọc ô tô theo nhà sản xuất
                    System.out.print("Nhap nha san xuat: ");
                    String manufacturer = scanner.nextLine();
                    dealership.filterCarsByManufacturer(manufacturer);
                    break;

                case 14:
                    //Lọc ô tô theo năm
                    System.out.print("Nhap nam san xuat: ");
                    int year = scanner.nextInt();
                    dealership.filterCarsByYear(year);
                    break;

                case 15:
                    //Lọc ô tô theo giá 
                    System.out.print("Nhap gia: ");
                    double price = scanner.nextDouble();
                    dealership.filterCarsByPrice(price);  //Gọi phương thức với giá chính xác
                    break;

                case 16:
                    //Hiển thị giao dịch theo ID xe
                    System.out.print("Nhap ID o to: ");
                    String transactionCarId = scanner.nextLine();
                    dealership.displayTransactionByCarId(transactionCarId);
                    break;

                case 17:
                    //Hiển thị giao dịch theo ID khách hàng
                    System.out.print("Nhap ID khach hang: ");
                    String transactionCustomerId = scanner.nextLine();
                    dealership.displayTransactionsByCustomer(transactionCustomerId);
                    break;

                case 18:
                    //Xuất báo cáo giao dịch ra file
                    System.out.print("Nhap ten file de xuat: ");
                    String fileName = scanner.nextLine();
                    dealership.exportTransactionsToFile(fileName);
                    break;

                case 19:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        } while (choice != 19);

        scanner.close();
    }
}

