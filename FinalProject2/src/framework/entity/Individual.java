package framework.entity;

import java.io.Serializable;
import java.time.LocalDate;


public class Individual extends CustomerImp implements Serializable{

     private LocalDate birthDate;
	public Individual() {
		super();
	}
     @Override
       public LocalDate getBirthDate() {
           
		return birthDate;
	}

     @Override
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}