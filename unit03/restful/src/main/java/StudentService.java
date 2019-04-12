import org.omg.CORBA.UserException;

import java.util.Collection;

public interface StudentService {

    public void addStudent (Student student);

    public Collection<Student> getStudents();

    public Student getStudent(String id);

    public Student editStudent(Student student) throws StudentException;

    public Student deleteStudent(String id);

    public boolean existStudent(String id);
}
