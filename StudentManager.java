import java.util.*;
class StudentManager{
    ArrayList<Student> list = new ArrayList<>();
    public Student idCheck(String oid)
    {
        for(Student s:list)
        {
            if(oid!=null && oid.equals(s.getId()))
            {
                return s;
            }
        }
        return null;
    }
    public boolean addStudent(String id,String name,int age,String course)
    {
        if(age<=0||name==null||name.isBlank()||course==null||course.isBlank())
        {
            return false;
        }
        Student s = idCheck(id);
        if(s==null)
        {
        Student stu = new Student(id, name, age, course);
        list.add(stu);
        return true;
        }
        return false;
    }
    public void view()
    {
        if(list.isEmpty()){
            System.out.println("No Student Details Available");
        return;}
        for(Student i : list)
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
        su.course=ucourse;
        return true;
    }
    public boolean delete(String oid)
    {
        Iterator<Student> st = list.iterator();
        while(st.hasNext())
        {
            Student s=st.next();
            if(oid.equals(s.getId())){
            st.remove();
            return true;
            }
        }
        return false;
    }
}