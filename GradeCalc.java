// Grade Calculator
// Create a Java application named Grade Calculator to calculate a 
// student's final grade based on
// subject marks.
// Users input marks for multiple subjects,
//  and the program computes total, average, and grade (A/B/C/etc.).---
// Arrays and loops are used to handle subjects and marks.
// Output includes detailed report and suggestions for improvement.
// Input validation and exception handling ensure data accuracy

import java.util.*;

public class GradeCalc {
    Scanner sc=new Scanner(System.in);
      String StudentName;    
        int Rollno;
        String[] Subject;
        int[] Marks;
        int Total;
        double Average;
        String Grade;
   

public void Input(){

//INPUT STUDENT NAME//
        System.out.println("ENTER THE NAME OF THE STUDENT :");
        StudentName=sc.nextLine();

//INPUT ROLL NUMBER//
        System.out.println("ENTER THE ROLL NO OF THE STUDENT :");
        Rollno=sc.nextInt();

        int count=0;


        //LOOP FOR VALID NUMBER OF SUBJECT WITH ATTEMPT//
    for(int attempt =1;attempt<=5;attempt++){
   
    try{
        
        System.out.println("ENTER THE NUMBER OF SUBJECTS :");
        count=sc.nextInt();

        if(count <=0){
            System.out.println("YOU NEED TO ENTER THE POSITIVE NUMBER :");
        }
        else {
            break;
        }
}
catch (InputMismatchException e){
    System.out.println("INPUT IS NOT VALID !! PLEASE ENTER THE NUMBER WHICH IS POSITIVE:");
    sc.next(); //clearing the invalid input
}

if(attempt==5){
    System.out.println("TOO MANY INVALID ATTEMPTS.. EXITING:");
    System.exit(0);
}

}


Subject = new String[count];
Marks =  new int[count];

//INPUT SUBJECT NAME AND MARKS WITH VALIDATION//

for(int i=0;i<count;i++){
    System.out.println("ENTER THE NAME OF THE SUBJECT :" +(i+1)+ ":");
    Subject[i]=sc.next();

    for(int attempt=1; attempt<=5;attempt++){

        try{    
                System.out.println("ENTER THE MARKS FOR " +Subject[i]+ "(0-100)");
                Marks[i]=sc.nextInt();

                if(Marks[i] < 0 || Marks[i] >100)
{
    System.out.println("YOUR MARKS SHOULD BE BETWEEN 0 AND 100");
}
else{
    break;
}
        }
catch(InputMismatchException e){
    System.out.println("INVALID INPUT ! PLS ENTER NUMBERS");
    sc.next(); //clearing the invalid input
}

if(attempt==5){

    System.out.println("TOO MANY INVALID ATTEMPTS: EXITNG!!");
    System.exit(0);
}
        } 
    }
}

//Calculating the total marks, average,
//  and assigns a grade based on the marks//

public void ResultCalculate(){

     Total =0;

    for(int mark:Marks)
{
    Total+=mark;
}
 Average = (double) Total / Marks.length;

if(Average >= 90)
      
            Grade = "A+";

else if(Average >= 80)
        
            Grade ="A";

 else if(Average >= 70)
        
            Grade ="B+";

else if(Average >= 60)
        
            Grade ="B";

else if(Average >= 50)
        
            Grade ="C";

            else if(Average >= 40)
            Grade = "D";

            else
            Grade ="E";


}

//Displaying the Report Card Of the Student//

public void MainResult(){

        System.out.println("******REPORT CARD OF THE STUDENT :*******");

            for(int i = 0;i<Subject.length;i++){
                System.out.println(Subject[i] + ":" +Marks[i] + "marks");
            }
            System.out.println("TOTAL MARKS :" +Total);
            System.out.println("AVERAGE MARKS :" +Average);
            System.out.println("FINAL GRADE :" +Grade);

            //Providing feedback based on grades//

            switch (Grade) {
                case "A+":
                    System.out.println("OUTSTANDING!! KEEP IT UP!!");
                break;

                case "A":
                    System.out.println("EXCELLENT!! KEEP IT UP !!");  
                 break;

                case "B+":
                    System.out.println("VRY GOOD !! KEEP IT UP!!");
                 break;

                 case "C":
                    System.out.println("GOOD !! YOU CAN DO IT BETTER !!");
                  break;

                case "D":
                    System.out.println("FAIR !! YOU CAN DO MORE MORE BETTER ... STAY FOCUSED:");
                break;
            
            default:
              System.out.println("FAIL !! LEARN MORE !!");
                    break;
            }
}

    public static void main(String[] args) {
       
        GradeCalc g = new GradeCalc();

        g.Input();
        g.ResultCalculate();
        g.MainResult();
    }
}