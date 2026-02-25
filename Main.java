import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean b = true;
        while (b) 
        { 
            System.out.println("\n\n\t\tMENU\n");
            System.out.println("1.AddStudent\n2.View Students\n3.Update Student\n4.Delete Student\n5.Search by ID\n6.Search by name\n7.Exit\n\nSelect any one Choice:");
            int choice = getIntValid(sc);
            switch(choice)
            {
                case 1: System.out.println("Enter Student id:");
                        String id=sc.nextLine();
                        System.out.println("Enter Student Name:");
                        String name=sc.nextLine();
                        System.out.println("Enter Student Age:");
                        int age=getIntValid(sc);
                        System.out.println("Enter Course of the Student:");
                        String course=sc.nextLine();
                        boolean res=manager.addStudent(id,name,age,course);
                        if(res)
                        {
                            System.out.println("\nAdded Succesfully");
                        }
                        else
                        {
                            System.out.println("\nFailed to add (age>0 and name,course cannot be null");
                        }
                        break;
                case 2: manager.view();
                        break;
                case 3: System.out.println("Enter Student ID:");
                        String nid=sc.nextLine();
                        Student su = manager.idCheck(nid);
                        if(su!=null)
                        {
                        System.out.println("\nId is valid\n");
                        System.out.println("\n1.NAME\n2.AGE\n3.COURSE\n");
                        System.out.println("Choose option to update:\n");
                        int c= getIntValid(sc);
                        switch (c) 
                        {
                                case 1:
                                    System.out.println("Enter Student name to update:");
                                    String uname = sc.nextLine();
                                    boolean check1=manager.updateName(su,uname);
                                    if(check1){
                                        System.out.println("\nUpdated Succesfully");
                                    }
                                    else{
                                        System.out.println("Name cannot be Empty , Failed to Update");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter Student age(>0) to update:");
                                    int uage = getIntValid(sc);
                                    boolean check2=manager.updateAge(su,uage);
                                    if(check2){
                                    System.out.println("\nUpdated Succesfully");
                                    }
                                    else
                                    {
                                        System.out.println("Age must be greater than 0, Failed to Update");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter Student course to update:");
                                    String ucourse = sc.nextLine();
                                    boolean check3=manager.updateCourse(su,ucourse);
                                    if(check3){
                                    System.out.println("\nUpdated Succesfully");}
                                    else{
                                        System.out.println("Course cannot be Empty, Failed to Update");
                                    }
                                    break;
                                default:
                                    System.out.println("invalid option");
                                    break;
                            }
                        }
                        else{
                            System.out.println("Invalid ID");
                        }
                        break;
                case 4: System.out.println("Enter Student ID to Delete:");
                        String oid = sc.nextLine();
                        boolean resu=manager.delete(oid);
                        if(resu)
                        {
                            System.out.println("\nDeleted Succesfully");
                        }
                        else{
                            System.out.println("\nFailed to delete");
                        }
                        break;
                case 5: System.out.println("\nEnter Student ID to search:");
                        String sid=sc.nextLine();
                        Student stu = manager.idCheck(sid);
                        if(stu!=null)
                        {
                            System.out.println("\n\t\tSTUDENT DETAILS\n");
                            System.out.println(" \tID \tNAME \tAGE \tCOURSE\n");
                            System.out.println(stu);
                        }
                        else
                        {
                            System.out.println("\nID not found");
                        }
                        break;
                case 6: System.out.println("\nEnter Student name to search:");
                        String sname = sc.nextLine();
                        manager.search_by_name(sname);
                        break;
                case 7: b=false;
                        break;
                default: System.out.println("\nInvalid Option");
                        break;
            }
        }
    }
    public static int getIntValid(Scanner sc)
    {
        while(true)
        {
            try
            {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input ; Please Enter valid Numeric\n");
                sc.nextLine();
            }
        }
    }
}