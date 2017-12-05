package xml_exam.UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import xml_exam.dao.Dao;
import xml_exam.domain.Student;
import xml_exam.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {

		try {
			System.out.println("���ѧ����a��		ɾ��ѧ����b��		��ѯ�ɼ���c��");
			System.out.print("������������ͣ�");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String type = br.readLine();
			
			if(type.equals("a")) {
				
				System.out.print("������ѧ��������");
				String name = br.readLine();
				System.out.print("������ѧ��׼��֤�ţ�");
				String examid = br.readLine();
				System.out.print("������ѧ�����֤�ţ�");
				String idcard = br.readLine();
				System.out.print("������ѧ�����ڵأ�");
				String location = br.readLine();
				System.out.print("������ѧ���ɼ���");
				String grade = br.readLine();
				
				Student s = new Student();
				s.setName(name);
				s.setExamid(examid);
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setGrade(Double.parseDouble(grade));
				Dao dao = new Dao();
				dao.add(s);
				System.out.println("��ӳɹ���");
				
			}else if(type.equals("b")) {
				
				System.out.print("������Ҫɾ����ѧ��������");
				String name = br.readLine();
				
				try {
				Dao dao = new Dao();
				dao.delete(name);
				System.out.println("ɾ���ɹ���");
				}catch (StudentNotExistException e) {
					System.out.println("��ѧ�������ڣ�");
				}
				
			}else if(type.equals("c")) {
				
				System.out.print("������Ҫ��ѯ��ѧ��׼��֤�ţ�");
				String examid = br.readLine();
				
				Dao dao = new Dao();
				Student s = dao.find(examid);
				if(s != null) {
					System.out.println("����ѯ��ѧ����ϢΪ��");
					System.out.print("������" + s.getName());
					System.out.print("�����֤�ţ�" + s.getIdcard());
					System.out.print("��׼��֤�ţ�" + s.getExamid());
					System.out.print("��������" + s.getLocation());
					System.out.println("���ɼ���" + s.getGrade());
				}else {
					System.out.println("����ѯ��ѧ�������ڣ�");
				}
				
			}else {
				System.out.println("��֧�ָò�����");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������");
		}
	}

}
