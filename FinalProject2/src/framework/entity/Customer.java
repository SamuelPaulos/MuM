package framework.entity;

import java.time.LocalDate;
import java.util.List;

public interface Customer {

	Long getId();

	void setId(Long id);
	
	String getName();

	void setName(String name);

        default LocalDate getBirthDate(){return null; };                                    

        default void setBirthDate(LocalDate birthDate){};
        default int getNumOfEmployees(){
            return 0;           
        }
        default void setNumOfEmployees( int numOfEmployees ){};
        

	String getEmail();

	void setEmail(String email);

	Address getAddress();

	void setAddress(Address address);

	List<Account> getAccounts();

	void setAccounts(List<Account> accounts);

}