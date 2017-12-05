package xml_exam.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import xml_exam.dao.Dao;
import xml_exam.domain.Student;
import xml_exam.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("添加学生（a）		删除学生（b）		查询成绩（c）");
			System.out.print("请输入操作类型：");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if(type.equals("a")) {
				
				System.out.print("请输入学生姓名：");
				String name = br.readLine();
				System.out.print("请输入学生准考证号：");
				String examid = br.readLine();
				System.out.print("请输入学生身份证号：");
				String idcard = br.readLine();
				System.out.print("请输入学生所在地：");
				String location = br.readLine();
				System.out.print("请输入学生成绩：");
				String grade = br.readLine();
				
				Student s = new Student();
				s.setName(name);
				s.setExamid(examid);
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setGrade(Double.parseDouble(grade));
				Dao dao = new Dao();
				dao.add(s);
				System.out.println("添加成功！");
				
			}else if(type.equals("b")) {
				
				System.out.print("请输入要删除的学生姓名：");
				String name = br.readLine();
				
				try {
				Dao dao = new Dao();
				dao.delete(name);
				System.out.println("删除成功！");
				}catch (StudentNotExistException e) {
					System.out.println("该学生不存在！");
				}
				
			}else if(type.equals("c")) {
				
				System.out.print("请输入要查询的学生准考证号：");
				String examid = br.readLine();
				
				Dao dao = new Dao();
				Student s = dao.find(examid);
				if(s != null) {
					System.out.println("您查询的学生信息为：");
					System.out.print("姓名：" + s.getName());
					System.out.print("，身份证号：" + s.getIdcard());
					System.out.print("，准考证号：" + s.getExamid());
					System.out.print("，地区：" + s.getLocation());
					System.out.println("，成绩：" + s.getGrade());
				}else {
					System.out.println("您查询的学生不存在！");
				}
				
			}else {
				System.out.println("不支持该操作！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("程序出错！");
		}
	}

}
