package framework.entity;

import java.io.Serializable;

public class Company extends CustomerImp implements Serializable{

     private int numOfEmployees;
	public Company() {
		super();
	}
        
        
       @Override
       public  int getNumOfEmployees(){
            return numOfEmployees;           
        }
       
       @Override
       public  void setNumOfEmployees(int numOfEmployees ){
          this.numOfEmployees=numOfEmployees;
                    };
        
	
}