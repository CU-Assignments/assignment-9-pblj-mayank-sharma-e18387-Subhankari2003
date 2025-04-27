package medium;

public class TestCRUD {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        dao.saveStudent(new Student("Bob", 20));
    }
}
