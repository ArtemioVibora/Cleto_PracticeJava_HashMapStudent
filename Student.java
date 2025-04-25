import java.util.*;
import java.io.*;

public class Student
{
    //Private variables/attributes
    private String studentName;
    private Double average;

    //HASHMAP AND BUFFERED READER
    public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<String, Double> studentMap = new HashMap<>();
    
    //Setters
    //Average
    public void setAverage(Double average)
    {
        this.average = average;
    }
    
    //Student Name
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    //Getters
    //Average
    public Double getAverage()
    {
        return average;
    }
    
    //Student Name
    public String getStudentName()
    {
        return studentName;
    }
    
    //Add function to get grades
    //For loop is needed... 1D array using ArrayList???
    public void inputStudentName()
    {
        boolean flag = true;
        while(flag)
        {
            try
            {
                System.out.print("What is student name: ");
                studentName = read.readLine();

                System.out.print("What is student average: ");
                average = Double.parseDouble(read.readLine());

                studentMap.put(studentName, average);
                flag = false;
            }
            catch(Exception e)
            {
                e.getMessage();

            }
        }
        flag = true;
    }
    
    //This function should be renamed to search student
    public void recallStudent()
    {
        try
        {
            System.out.print("Enter Student Name: ");
            studentName = read.readLine();

            //Not sure if I should use a for loop for this
            for (Map.Entry<String, Double> mapEntry : studentMap.entrySet())
            {
                if (studentName.equals(mapEntry.getKey()))
                {
                    System.out.println("Student name: " + mapEntry.getKey() + ", Average: " + mapEntry.getValue());
                }
                else
                {
                    System.out.println("Student not found!");

                }
            }

        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    //This function prints all students using HashMap
    public void printAllStudents()
    {
        for (Map.Entry<String, Double> mapEntry : studentMap.entrySet())
        {
            System.out.println("Student name: " + mapEntry.getKey() + ", Average: " + mapEntry.getValue());

        }

    }

    public void removeStudent()
    {
        try
        {
            System.out.print("Student name: ");
            studentName = read.readLine();
            for (Map.Entry <String, Double> mapEntry : studentMap.entrySet())
            {
                if (studentName.equals(mapEntry.getKey()))
                {
                    studentMap.remove(studentName);

                }
                else
                {
                    System.out.println("Student Not Found!");
                }

            }
        }
        //Generic error exception... needs to be more specific
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    //Menu
    public static void menuPrompt()
    {
        int input = 0;

        Student student = new Student();

        boolean flag = true;
        while(flag)
        {
            System.out.println("================================");
            System.out.println("<1> Add student");
            System.out.println("<2> Recall student");
            System.out.println("<3> Print all students");
            System.out.println("<4> Print hash map");
            System.out.println("<5> Remove student ");
            System.out.println("<6> Quit");
            System.out.println("================================");

            try
            {
                System.out.print("Enter input: ");
                input = Integer.parseInt(read.readLine());
                switch(input)
                {
                    case 1:
                        student.inputStudentName();
                        break;
                    case 2:
                        student.recallStudent();
                        break;
                    case 3:
                        student.printAllStudents();
                        break;
                    case 4:
                        System.out.println(studentMap);
                        break;
                    case 5:
                        student.removeStudent();
                        break;
                    case 6:
                        // Funny flag with break holy shit
                        flag = false;
                        break;
                    default:
                        System.out.println("Error: Invalid Input!");
                        break;
                }

            }
            //Find a more specific exception. IOException should suffice
            catch(Exception e)
            {
                e.getMessage();


            }
           
        }

    }

    public static void main(String args[])
    {
        menuPrompt(); 
    }    

}
