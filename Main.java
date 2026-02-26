
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean b = true;
        while (b) {
            System.out.println("\n\n\t\tMENU\n");
            System.out.println("1.AddStudent\n2.View Students\n3.Update Student\n4.Delete Student\n5.Search by ID\n6.Search by name\n7.Exit\n\nSelect any one Choice:");
            int choice = getIntValid(sc);
            switch (choice) {
                case 1:
                    handleAdd(sc, manager);
                    break;
                case 2:
                    List<Student> dup = manager.view();
                    printStudents(dup);
                    break;
                case 3:
                    handleUpdate(sc, manager);
                    break;
                case 4:
                    handleDelete(sc, manager);
                    break;
                case 5:
                    searchID(sc, manager);
                    break;
                case 6:
                    searchName(sc, manager);
                    break;
                case 7:
                    System.out.println("Exiting Program...");
                    b = false;
                    break;
                default:
                    System.out.println("\nInvalid Option");
                    break;
            }
        }
    }

    public static int getIntValid(Scanner sc) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input ; Please Enter valid Numeric\n");
                sc.nextLine();
            }
        }
    }

    public static void handleAdd(Scanner sc, StudentManager manager) {
        System.out.println("Enter Student id:");
        String id = sc.nextLine().trim();
        System.out.println("Enter Student Name:");
        String name = sc.nextLine().trim();
        System.out.println("Enter Student Age:");
        int age = getIntValid(sc);
        System.out.println("Enter Course of the Student:");
        String course = sc.nextLine().trim();
        boolean res = manager.addStudent(id, name, age, course);
        if (res) {
            System.out.println("\nAdded Succesfully");
        } else {
            System.out.println("\nFailed to add (age>0 and name,course cannot be null");
        }
    }

    public static void handleUpdate(Scanner sc, StudentManager manager) {
        System.out.println("Enter Student ID:");
        String nid = sc.nextLine().trim();
            System.out.println("\n1.NAME\n2.AGE\n3.COURSE\n");
            System.out.println("Choose option to update:\n");
            int c = getIntValid(sc);
            switch (c) {
                case 1:
                    System.out.println("Enter Student name to update:");
                    String uname = sc.nextLine().trim();
                    boolean check1 = manager.updateName(nid, uname);
                    if (check1) {
                        System.out.println("\nUpdated Succesfully");
                    } else {
                        System.out.println("Name cannot be Empty or ID not found , Failed to Update");
                    }
                    break;
                case 2:
                    System.out.println("Enter Student age(>0) to update:");
                    int uage = getIntValid(sc);
                    boolean check2 = manager.updateAge(nid, uage);
                    if (check2) {
                        System.out.println("\nUpdated Succesfully");
                    } else {
                        System.out.println("Age must be greater than 0 and ID Cannot be Empty, Failed to Update");
                    }
                    break;
                case 3:
                    System.out.println("Enter Student course to update:");
                    String ucourse = sc.nextLine().trim();
                    boolean check3 = manager.updateCourse(nid, ucourse);
                    if (check3) {
                        System.out.println("\nUpdated Succesfully");
                    } else {
                        System.out.println("Course and ID cannot be Empty, Failed to Update");
                    }
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
    }

    public static void handleDelete(Scanner sc, StudentManager manager) {
        System.out.println("Enter Student ID to Delete:");
        String oid = sc.nextLine().trim();
        boolean resu = manager.deleteById(oid);
        if (resu) {
            System.out.println("\nDeleted Succesfully");
        } else {
            System.out.println("\nFailed to delete ; Enter Valid ID");
        }
    }

    public static void searchID(Scanner sc, StudentManager manager) {
        System.out.println("\nEnter Student ID to search:");
        String sid = sc.nextLine().trim();
        Student stu = manager.findById(sid);
        if (stu != null) {
            System.out.println("\n\t\tSTUDENT DETAILS\n");
            System.out.println(" \tID \tNAME \tAGE \tCOURSE\n");
            System.out.println(stu);
        } else {
            System.out.println("\nID not found");
        }
    }

    public static void searchName(Scanner sc, StudentManager manager) {
        System.out.println("\nEnter Student name to search:");
        String sname = sc.nextLine().trim();
        List<Student> val = manager.searchByName(sname.trim());
        printStudents(val);
    }
    public static void printStudents(List<Student> arr)
    {
        if(arr.isEmpty())
        {
            System.out.println("Student Details are not Available");
        }
        else{
        System.out.println("\n\t\tSTUDENT DETAILS\n");
        System.out.println("\tID \tNAME \tAGE \tCOURSE\n");
        for(Student s : arr)
        {
            System.out.println(s);
        }
    }
    }
}
