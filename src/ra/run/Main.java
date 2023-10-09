package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=====BASIC-MENU====");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    save();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    sortDownInterest();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    changeStatus();
                    break;
                case 7:
                    System.out.println("Đã thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn 1 -> 3. Vui lòng thử lại.");
            }
        } while (true);

    }

    //1. Nhập số sách và nhập thông tin sách
    public static void save() {
        System.out.print("Nhập số sách cần thêm mới: ");
        int numBookToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numBookToAdd; i++) {
            Book bookNew = new Book();
            bookNew.inputData();
            bookList.add(bookNew);
        }
    }


    //2. Hiển thị thông tin các sách
    public static void showBook(){
        for (Book item: bookList) {
            item.displayData();
        }
    }

    //3. Sắp xếp sách theo lợi nhuận giảm dần.
    public static void sortDownInterest() {
        Collections.sort(bookList,(s1, s2)->Double.compare(s2.getInterest(), s1.getInterest()));
        for (Book element : bookList) {
            element.displayData();
        }
    }

    //4. Xóa sách theo mã sách
    public static void delete(){
        System.out.println("Nhập mã sách cần xoá");
        int deleteId = Integer.parseInt(sc.nextLine());
        boolean check = false;
        Book deleteBook = new Book();
        for (Book element : bookList) {
            if(element.getBookId() == deleteId){
                deleteBook = element;
                check = true;
                break;
            }
        }
        if(check){
            bookList.remove(deleteBook);
        }else {
            System.out.println("Mã sách cần xoá không tìm thấy");
        }
    }

    //5. Tìm kiếm sách theo tên sách
    public static void search(){
        System.out.println("Nhập tên sách cần tìm");
        String searchName = sc.nextLine();
        for (Book item : bookList) {
            if (item.getBookName().toLowerCase().contains(searchName.toLowerCase())) {
                item.displayData();
            }else {
                System.out.println("Sản phầm không tìm thấy");
            }
        }

    }


   // 6. Thay đổi trạng thái của sách theo mã sách
   public static void changeStatus(){
       System.out.println("Nhập mã sách cần thay đổi trạng thái");
       int changeIdStatus = Integer.parseInt(sc.nextLine());
       boolean check = false;
       Book changeBook = new Book();
       for (Book element : bookList) {
           if(element.getBookId() == changeIdStatus){
               changeBook = element;
               check = true;
               break;
           }
       }
       if(check){
           changeBook.setBookStatus(!changeBook.isBookStatus());
           changeBook.displayData();
       }else {
           System.out.println("Mã sách cần xoá không tìm thấy");
       }

   }

}
