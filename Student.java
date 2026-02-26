class Student{
    private final String id;
    private String name;
    private int age;
    private String course;
    public Student(String id,String name,int age,String course)
    {
        if(id==null || id.isBlank() || name==null || name.isBlank()||age<=0||course==null || course.isBlank())
        {
            throw new IllegalArgumentException("Invalid Input");
        }
        this.id=id.trim();
        this.name=name.trim();
        this.age=age;
        this.course=course.trim();
    }
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getCourse()
    {
        return course;
    }
    public void setName(String name)
    {
        this.name=name.trim();
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setCourse(String course)
    {
        this.course=course.trim();
    }
    @Override
    public String toString()
    {
        return id+"\t"+name+"\t"+age+"\t"+course;
    }
}