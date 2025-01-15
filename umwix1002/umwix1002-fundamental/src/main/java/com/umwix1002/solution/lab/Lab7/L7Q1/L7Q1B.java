package Lab7.L7Q1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import Lab7.Generator;

public class L7Q1B {
    public static void main(String[] args) {
        List<Course> courseList = getCourseList(Generator.COURSE_FILE);
		Scanner scanner = new Scanner(System.in);
		
        Outer:
		while(true) {
			System.out.print("Enter the course code (enter q to quit): ");
			String courseCode = scanner.nextLine();
			
			if (courseCode.charAt(0) == 'q') break;
			
            for(Course course : courseList) 
                if(course.getCourseCode().equals(courseCode)) {
                    System.out.printf("Course Code: %s\nCourse Name: %s\n\n", course.getCourseCode(), course.getCourseName());
                    continue Outer;
                }
            
			System.out.println("The course doesn't exist.\n");
		}
		
		scanner.close();
    }

    public static List<Course> getCourseList(String fromFile) {
		List<Course> courseList = new ArrayList<>();
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fromFile))) {
			String line;
			while((line = (String) reader.readObject()) != null) {
				String[] courseInfo = line.split(",");
				courseList.add(new Course(courseInfo[0], courseInfo[1]));
			}

		} catch (Exception ex) {}
		
		return courseList;
	}
}

class Course {
    private String courseCode;
    private String courseName;
    
    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
}
