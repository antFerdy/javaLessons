import java.io.*;
class ClassB {
 
  public static void main(String args[]){
       
    FileInputStream fIn=null;
    ObjectInputStream oIn=null;
    Employee bestEemp = null;
    try{   
     fIn = new  FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\employee.ser");
     oIn = new ObjectInputStream(fIn);
     bestEemp=(Employee)oIn.readObject();
     
     
   } catch (ClassNotFoundException cnf){
             cnf.printStackTrace();
   } catch (IOException e){
          
       try{ 
         oIn.close();
         fIn.close();
       }catch (IOException ioe){
         ioe.printStackTrace();
       }
   }  
   System.out.println("The Employee  object has been deserialized from " +  
		   "C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\employee.ser");
   System.out.println(bestEemp.printName());
  } 
}