import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StudentServiceMapImpl implements StudentService{

    private static final String EMAIL_REGEX = "mercadolibre.com";

    private HashMap<String, Student> studentMap;

    public StudentServiceMapImpl() {
        this.studentMap = new HashMap<String, Student>();
    }

    public StudentServiceMapImpl(HashMap<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public void addStudent(Student student) {
        this.studentMap.put(student.getId(), student);
    }

    @Override
    public Collection<Student> getStudents() { return this.studentMap.values();
    }

    @Override
    public Student getStudent(String id) {
        return this.studentMap.get(id);
    }

    @Override
    public Student editStudent(Student student) throws StudentException {
        try {
            if (student.getId() == null) {
                throw new StudentException("Id cant be null.");
            }
            if (this.existStudent(student.getId())) {
                Student studentToEdit = studentMap.get(student.getId());
                if (student.getEmail() != null){
                    studentToEdit.setEmail(student.getEmail());
                }
                if (student.getLastName() != null) {
                    studentToEdit.setLastName(student.getLastName());
                }
                if (student.getFirstName() != null) {
                    studentToEdit.setFirstName(student.getFirstName());
                }
                return studentToEdit;
            }
            return null;
        } catch (Exception e){
            throw new StudentException(e.getMessage());
        }
    }

    @Override
    public Student deleteStudent(String id) {
            return studentMap.remove(id);
    }

    @Override
    public boolean existStudent(String id) {
        return this.studentMap.containsKey(id);
    }

    public Collection<Student> getStudentsList() {
        return this.studentMap.values();
    }

    public Collection<Student> getFilterStudentByLastNameCapitalLeter(String[] capitalLetters) {
        return this.studentMap.values()
                .stream()
                .filter(student -> {
                    for (String capitalLetter: capitalLetters) {
                        if (student.getLastName().toLowerCase().startsWith(capitalLetter.trim().toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public Collection<Student> getFilterStudentByEmailLenght(int lengthFilter) {
        return this.studentMap.values()
                .stream()
                .filter(student ->
                        student.getEmail().toLowerCase().replace(EMAIL_REGEX, "").length() > lengthFilter
                )
                .collect(Collectors.toList());
    }

    public Collection<Student> getFilterStudentByLastNameContains(String letter) {
        return this.studentMap.values()
                .stream()
                .filter(student -> student.getLastName().toLowerCase().contains(letter))
                .collect(Collectors.toList());
    }
}
