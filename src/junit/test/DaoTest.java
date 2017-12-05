package junit.test;

import org.junit.Test;

import xml_exam.dao.Dao;
import xml_exam.domain.Student;
import xml_exam.exception.StudentNotExistException;

public class DaoTest {
	
	@Test
	public void testAdd() {
		Dao dao = new Dao();
		Student s = new Student();
		s.setIdcard("123");
		s.setExamid("321");
		s.setName("王五");
		s.setLocation("北京");
		s.setGrade(90);
		dao.add(s);
	}
	
	@Test
	public void testFind() {
		Dao dao = new Dao();
		dao.find("321");
	}
	
	@Test
	public void testDelete() throws StudentNotExistException {
		Dao dao = new Dao();
		dao.delete("王五");
	}
}
