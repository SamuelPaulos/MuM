package creditCard.entity;

import framework.entity.Staff;


import framework.validator.Empty;
import framework.validator.Required;
import framework.validator.UserModel;
import framework.validator.Number;

public class CreditStaff extends UserModel implements Staff{

    @Required(name = "username", value = "Username is Required")
    String username;

    @Empty(name = "password", value = "Password is Required")
    String pwd;

    @Empty(name = "position", value = "Position can't be Empty")
    String pos;

    @Empty(name = "firstname", value = "Firstname can't be Empty")
    @Required(name = "firstname", value = "Firstname is Required")
    String fname;

    @Empty(name = "lastname", value = "Lastname can't be Empty")
    String lname;

    @Empty(name = "gender", value = "Gender can't be Empty")
    @Required(name = "gender", value = "Gender is Required")
    String gender;
    
    @Empty(name = "age", value = "Age can't be Empty")
    @Number(name = "age", value = "Age should be Number") 
    int age;
    

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    public String getPosition() {
        return pos;
    }

    public void setPosition(String pos) {
        this.pos = pos;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

}
