
import java.io.*;
import java.util.*;

class StudentManager {

    private final Map<String, Student> list = new TreeMap<>();

    private final String fileName = "Student.csv";

    StudentManager()
    {
        loadFromFile();
    }

    public Student findById(String oid) {
        if (oid == null) {
            return null;
        }
        return list.get(oid.trim());
    }

    public boolean addStudent(String id, String name, int age, String course) {
        if (id == null || id.isBlank() || age <= 0 || name == null || name.isBlank() || course == null || course.isBlank()) {
            return false;
        }
        Student s = findById(id);
        if (s == null) {
            try{
            s = new Student(id, name, age, course);
            }
            catch(IllegalArgumentException e)
            {
                return false;
            }
            list.put(id.trim(), s);
            saveToFile();
            return true;
        }
        return false;
    }

    public List<Student> searchByName(String sname) {
         List<Student> names = new ArrayList<>();
        if (sname == null || sname.isBlank()) {
            return names;
        } else {
            for (Student s : list.values()) {
                if (s.getName().equalsIgnoreCase(sname)) {
                    names.add(s);
                }
            }
            return Collections.unmodifiableList(names);
        }
    }

    public List<Student> searchByCourse(String scourse)
    {
        List<Student> stu = new ArrayList<>();
        if(scourse==null || scourse.isBlank())
        {
            return stu;
        }
        for(Student s : list.values())
        {
            if(s.getCourse().equalsIgnoreCase(scourse))
            {
                stu.add(s);
            }
        } 
        return Collections.unmodifiableList(stu);
    }
    public List<Student> view() {
        List<Student> arr = new ArrayList<>(list.values());
        return Collections.unmodifiableList(arr);
    }

    public boolean updateName(String nid, String uname) {
        if (uname == null || uname.isBlank()) {
            return false;
        }
        Student stu = findById(nid);
        if(stu!=null)
        {
        stu.setName(uname.trim());
        saveToFile();
        return true;
        }
        return false;
    }

    public boolean updateAge(String nid, int uage) {
        if (uage <= 0) {
            return false;
        }
        Student stu = findById(nid);
        if(stu!=null)
        {
        stu.setAge(uage);
        saveToFile();
        return true;
        }
        return false;
    }

    public boolean updateCourse(String nid, String ucourse) {
        if (ucourse == null || ucourse.isBlank()) {
            return false;
        }
         Student stu = findById(nid);
        if(stu!=null)
        {
        stu.setCourse(ucourse.trim());
        saveToFile();
        return true;}
        return false;
    }

    public boolean deleteById(String oid) {
        if(oid==null)
        {
            return false;
        }
        if (list.containsKey(oid.trim())) {
            list.remove(oid.trim());
            saveToFile();
            return true;
        }
        return false;
    }
    public void saveToFile()
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for(Student stu : list.values())
            {
                writer.write(stu.getId()+":"+stu.getName()+":"+stu.getAge()+":"+stu.getCourse());
                writer.newLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("File Writer Error "+e.getMessage());
        }
    }
    public final void loadFromFile()
    {
        File file = new File(fileName);
        if(!file.exists())
        {
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                String[] parts = line.split(":");
                if(parts.length!=4)
                {
                    continue;
                }
                try{
                String sid = parts[0].trim();
                String sname = parts[1].trim();
                int sage = Integer.parseInt(parts[2].trim());
                String scourse = parts[3].trim();
                Student stu = new Student(sid,sname,sage,scourse);
                list.put(sid,stu);
                }
                catch(NumberFormatException e)
                {
                    continue;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("File Read Error "+e.getMessage());
        }
    }
}
