package CodeSoftTask;
import java.util.*;
public class StudentGradeCalculator 
{
 public static void main(String[] args) 
 {
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter number of subjects");
     int numberOfSubjects = sc.nextInt();
     float totalMarks = 0;
     for (int i = 1; i <= numberOfSubjects; i++) 
     {
       System.out.println("Enter marks for subject"+" "+i);
       float marks = sc.nextFloat();
       totalMarks += marks;
     }
     float averagePercentage = totalMarks/numberOfSubjects;
     char grade;
     sc.close();
     if (averagePercentage>=90) 
     {
       grade = 'S';
     }
       else if (averagePercentage>=80 && averagePercentage<=89) 
       {
           grade = 'A';
       } 
     else if(averagePercentage>=70 && averagePercentage<=79)
     {
           grade = 'B';
     }
    else if(averagePercentage>=60 && averagePercentage<=69)
     {
           grade = 'C';
     }
    else if(averagePercentage>=50 && averagePercentage<=59)
     {
           grade = 'D';
     }
   else if(averagePercentage>=35 && averagePercentage<=49)
     {
           grade = 'E';
     }
          else
     {
           grade = 'F';
     }
     System.out.println("TotalMarks..."+totalMarks);
     System.out.println("AveragePercentage..."+averagePercentage);
     System.out.println("Grade..."+grade);
 }
}