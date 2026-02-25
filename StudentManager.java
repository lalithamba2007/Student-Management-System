import java.util.*;
class StudentManager{
    TreeMap<String,Student> list = new TreeMap<>();
    public Student idCheck(String oid)
    {
        if (oid==null)
        {
            return null;
        }
        return list.get(oid);
    }
    public boolean addStudent(String id,String name,int age,String course)
    {
        if(id==null||id.isBlank()||age<=0||name==null||name.isBlank()||course==null||course.isBlank())
        {
            return false;
        }
        Student s = idCheck(id);
        if(s==null)
        {
        Student stu = new Student(id, name, age, course);
        list.put(id,stu);
        return true;
        }
        return false;
    }
    public void search_by_name(String sname)
    {
        if(sname==null || sname.isBlank())
        {
            System.out.println("\nInvalid Name");
            return;
        }
        boolean flag=false;
        System.out.println("\n\t\tSTUDENT DETAILS\n");
        System.out.println(" \tID \tNAME \tAGE \tCOURSE\n");
        for(Student s : list.values())
        {
            if(s.getName().equalsIgnoreCase(sname))
            {
                System.out.println(s);
                flag=true;
            }
        }
        if(!flag)
        {
            System.out.println("\nName not found");
        }
    }
    public void view()
    {
        if(list.isEmpty()){
            System.out.println("Student Details Unavailable");
        return;}
        System.out.println("\n\t\tSTUDENT DETAILS\n");
        System.out.println(" \tID \tNAME \tAGE \tCOURSE\n");
        for(Student i : list.values())
        {
            System.out.println(i);
        }
    }
    public boolean updateName(Student su,String uname)
    {
        if(uname==null||uname.isBlank())
            return false;
        su.setName(uname);
        return true;
    }
    public boolean updateAge(Student su,int uage)
    {
        if(uage<=0)
            return false;
         su.setAge(uage);
         return true;
    }
    public boolean updateCourse(Student su,String ucourse)
    {
        if(ucourse==null||ucourse.isBlank())
            return false;
        su.setCourse(ucourse);
        return true;
    }
    public boolean delete(String oid)
    {
        if(list.containsKey(oid))
        {
            list.remove(oid);
            return true;
        }
        return false;
    }
}