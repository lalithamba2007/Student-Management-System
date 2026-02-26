
import java.util.*;

class StudentManager {

    private final Map<String, Student> list = new TreeMap<>();

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
            return true;
        }
        return false;
    }
}
