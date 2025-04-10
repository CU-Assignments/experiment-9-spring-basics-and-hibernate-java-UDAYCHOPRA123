import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public void saveStudent(Student student) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student getStudent(int id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    // update, delete, listAll etc.
}

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.saveStudent(new Student("John", 22));
        Student s = dao.getStudent(1);
        System.out.println("Fetched: " + s.getName());
    }
}
