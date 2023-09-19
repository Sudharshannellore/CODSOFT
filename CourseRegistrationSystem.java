import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false; // Course is full
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSlots() {
        return capacity - enrolledStudents.size();
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerForCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course fullStackCourse = new Course("FLStaDev1", "FullStackDevelopment", "Frontend, Backend, DataBase, Tools", 30);
        Course dataScienceCourse = new Course("DataSci12", "Data Science", "to analyze data and derive practical company knowledge", 30);
        Course artificialIntelligenceCourse = new Course("AI1134", "Artificial Intelligence", " The capacity of a computer or a robot controlled by a computer to do duties traditionally carried out by people since they call for human intelligence and judgment", 30);
        Course digitalMarketing = new Course("DM2002", "Digital Marketing", "The use of the internet and other digital communication channels for company advertising in order to reach out interested customers", 30);

        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Register for a course");
            System.out.println("2. Drop a course");
            System.out.println("3. Display available courses");
            System.out.println("4. Display student details and registered courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    Student newStudent = new Student(students.size() + 1, studentName);

                    System.out.println("Available Courses:");
                    System.out.println("1. " + fullStackCourse.getTitle() + " (Available Slots: " + fullStackCourse.getAvailableSlots() + ")");
                    System.out.println("2. " + dataScienceCourse.getTitle() + " (Available Slots: " + dataScienceCourse.getAvailableSlots() + ")");
                    System.out.println("3. " + artificialIntelligenceCourse.getTitle() + " (Available Slots: " + artificialIntelligenceCourse.getAvailableSlots() + ")");
                    System.out.println("4. " + digitalMarketing.getTitle() + " (Available Slots: " + digitalMarketing.getAvailableSlots() + ")");
                    System.out.print("Enter the course number to register (1/2/3/4): ");
                    int courseChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Course selectedCourse = null;

                    if (courseChoice == 1) {
                        selectedCourse = fullStackCourse;
                    } else if (courseChoice == 2) {
                        selectedCourse = dataScienceCourse;
                    } else if (courseChoice == 3) {
                        selectedCourse = artificialIntelligenceCourse;
                    } else if (courseChoice == 4) {
                        selectedCourse = digitalMarketing;
                    } else {
                        System.out.println("Invalid course choice.");
                        break;
                    }

                    if (selectedCourse != null) {
                        if (selectedCourse.enrollStudent(newStudent)) {
                            students.add(newStudent);
                            System.out.println(studentName + " is registered for " + selectedCourse.getTitle());
                        } else {
                            System.out.println("Sorry, " + selectedCourse.getTitle() + " is full.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentNameDrop = scanner.nextLine();
                    System.out.println(studentNameDrop + "'s registered courses:");
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(studentNameDrop)) {
                            List<Course> registeredCourses = student.getRegisteredCourses();
                            for (Course course : registeredCourses) {
                                System.out.println(course.getCode() + " - " + course.getTitle());
                            }
                            System.out.print("Enter the course code to drop: ");
                            String courseCode = scanner.nextLine();
                            for (Course course : registeredCourses) {
                                if (course.getCode().equals(courseCode)) {
                                    student.dropCourse(course);
                                    System.out.println(studentNameDrop + " dropped " + course.getTitle());
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Available Courses:");
                    System.out.println("1. " + fullStackCourse.getTitle() + " (Available Slots: " + fullStackCourse.getAvailableSlots() + ")");
                    System.out.println("2. " + dataScienceCourse.getTitle() + " (Available Slots: " + dataScienceCourse.getAvailableSlots() + ")");
                    System.out.println("3. " + artificialIntelligenceCourse.getTitle() + " (Available Slots: " + artificialIntelligenceCourse.getAvailableSlots() + ")");
                    System.out.println("4. " + digitalMarketing.getTitle() + " (Available Slots: " + digitalMarketing.getAvailableSlots() + ")");
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    String studentNameDetails = scanner.nextLine();
                    boolean found = false;

                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(studentNameDetails)) {
                            System.out.println("Student Details:");
                            System.out.println("Student ID: " + student.getStudentID());
                            System.out.println("Student Name: " + student.getName());

                            List<Course> registeredCourses = student.getRegisteredCourses();
                            if (!registeredCourses.isEmpty()) {
                                System.out.println("Registered Courses:");
                                for (Course course : registeredCourses) {
                                    System.out.println(course.getCode() + " - " + course.getTitle());
                                }
                            } else {
                                System.out.println(student.getName() + " is not registered for any courses.");
                            }
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
