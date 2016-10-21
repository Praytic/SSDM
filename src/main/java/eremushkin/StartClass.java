package eremushkin;

import eremushkin.entity.Student;
import eremushkin.repository.AbstractEntityRepository;
import eremushkin.repository.EntityRepository;
import eremushkin.repository.imp.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Daniil on 18.10.2016.
 */
@Component
public class StartClass {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EntityRepository<Student, Long> repository = (EntityRepository<Student, Long>) context.getBean("studentRepository");
        repository.add(new Student("firstNameTest", "secondNameTest"));
    }
}
