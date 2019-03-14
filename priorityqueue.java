import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student 
{
	private int token;
	private String name;
	private double cgpa;

	public Student(int token, String name, double cgpa) 
	{
		this.token = token;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getToken() 
	{
		return token;
	}

	public String getname() 
	{
		return name;
	}

	public double getCgpa() 
	{
		return cgpa;
	}

}

class Solution 
{
	public static void main(String[] args) 
	{	System.out.println("Enter Input : \n");
		Scanner in = new Scanner(System.in);
		int totalEvents = in.nextInt();
		
		PriorityQueue<Student> pQ = new PriorityQueue<Student>
		(	
				new Comparator<Student>() 
				{
					
					public int compare(Student student1, Student student2) 
					{
						// if cgpa is not equal -- sort according to field one
			
						if (student1.getCgpa() != student2.getCgpa())
						{ 	
							if(student1.getCgpa() > student2.getCgpa())
								return -1;
							else
								return 1;							
						}

						// if cgpa is equal sort according to name -- sort condition 2
						else 
						{	

							// if first name is also equal, sort according to Token() -- sort condition 3
							if (  ( student1.getname().compareTo(student2.getname()) ) != 0)
							{ 
								return student1.getname().compareTo(student2.getname());
							}

							else
								return student1.getToken() - student2.getToken(); 
						}
					}
				}
		);
		
		
		
		for (int i = 0; i < totalEvents; i++) 
		{
			String event = in.next();

            if (event.equals("ENTER"))
            {
                String name = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                
                Student student = new Student(token, name, cgpa);
                
                pQ.add(student);				
            } 

            else if (event.equals("SERVED")) 
            {	//poll() returns head of the queue and returns null if queue is empty
            	pQ.poll(); 	
            }
		}
		
		
		System.out.println("\nOutput : \n");
		if ( pQ.isEmpty() ) 
		{
			System.out.println("EMPTY");
		} 

		else 
		{
			 
			Student stu = pQ.poll();
			while (stu!=null)
			{
				System.out.println(stu.getname());
				stu = pQ.poll();

			}
				
		}
	}
}