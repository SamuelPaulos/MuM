package framework.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import banking.entity.BankStaff;
import banking.factory.entity.BankAccountFactory;
import banking.factory.entity.BankAccountType;
import framework.entity.Account;
import framework.entity.AccountEntry;
import framework.entity.AccountEntryImp;
import framework.entity.Address;
import framework.entity.Customer;
import framework.factory.entity.AccountFactory;
import framework.factory.entity.AccountType;
import framework.factory.entity.CustomerFactory;
import framework.factory.entity.CustomerType;

public class AccountDAOImp implements AccountDAO {
	private Map<String, Account> dataMap = new HashMap<>();
	private static Connection con;
	private static Statement mystmt;
	private Account account;
	private Customer customer;
	private AccountFactory accountFactory = new BankAccountFactory();
	
	private Collection<Account>accountlist=new ArrayList<>();
	private BankStaff bankstaff;
	private  List<BankStaff> stafflist=new ArrayList<>();
	
	static{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?autoReconnect=true&useSSL=false", "samuel", "1234");
			mystmt= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public AccountDAOImp() {
		customer=CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
		Address address= new Address();
	
		customer.setAddress(address);
		account=accountFactory.createAccount(BankAccountType.CHECKING);
		account.setCustomer(customer);
	}

	@Override
	public void saveAccount(Account account) {
		
		dataMap.put(account.getAccountNumber(), account);
		//----------------------
		System.out.println(account);
	
		String sql1 = "INSERT INTO address (street, city, zip, state)"+
					    " VALUES (?,?,?,?);";
		String sql2 = "INSERT INTO customer (name, email, accountID, addressID)"+
			    " VALUES (?,?,?,?);";
		String sql3 = "INSERT INTO account (accountNumber, balance,CustomerID, accountType)"+
		   " VALUES (?,?,?,?);";
		//PreparedStatement preparedStatement1;
		PreparedStatement preparedStatement;
		PreparedStatement preparedStatement2;
		PreparedStatement preparedStatement3;
		PreparedStatement preparedStatementselect;
		PreparedStatement preparedStatementcust;
		PreparedStatement preparedStatementacc;
		try {
//			preparedStatement1=con.prepareStatement("ALTER TABLE address AUTO_INCREMENT=1001");
//			preparedStatement1.execute();
			preparedStatement = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			
			
			preparedStatement.setString(1, account.getCustomer().getAddress().getStreet());
			preparedStatement.setString(2, account.getCustomer().getAddress().getCity());
			preparedStatement.setString(3, account.getCustomer().getAddress().getZip());
			preparedStatement.setString(4, account.getCustomer().getAddress().getState());
			preparedStatement.execute();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			int last_inserted_id=0;
            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
                System.out.println(last_inserted_id);
            }

            preparedStatementcust=con.prepareStatement("ALTER TABLE customer AUTO_INCREMENT=100");
			preparedStatementcust.execute();
			
			preparedStatement2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			preparedStatement2.setString(1, account.getCustomer().getName());
			preparedStatement2.setString(2, account.getCustomer().getEmail());
			preparedStatement2.setInt(3, Integer.parseInt(account.getAccountNumber()));
			preparedStatement2.setInt(4, last_inserted_id);
			
			preparedStatement2.execute();
		
			
			
			ResultSet rs2 = preparedStatement2.getGeneratedKeys();
			int last_inserted_id2=0;
            if(rs2.next())
            {
                last_inserted_id2 = rs2.getInt(1);
                System.out.println(last_inserted_id2);
            }
            
            preparedStatementacc=con.prepareStatement("ALTER TABLE account AUTO_INCREMENT=10001");
			preparedStatementacc.execute();
			
			preparedStatement3 = con.prepareStatement(sql3);
			preparedStatement3.setInt(1, Integer.parseInt(account.getAccountNumber()));
			preparedStatement3.setDouble(2, account.getBalance());
			preparedStatement3.setInt(3, last_inserted_id2);
			
			String accType="SAVING";
			if(account.getAccountType()==BankAccountType.CHECKING){
				accType="CHECKING";
			}
				
				preparedStatement3.setString(4, accType);
			preparedStatement3.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		log();
	}

	@Override
	public void updateAccount(Account account) {
		//dataMap.put(account.getAccountNumber(), account);
		//---------------------------------------
		String sql = "update bankdb.account "+
                   " set account.balance="+ account.getBalance().intValue()+
                  " where account.accountNumber="+account.getAccountNumber()+";";
		
			PreparedStatement preparedStatement;
			PreparedStatement preparedStatement1;
			PreparedStatement preparedStatementent;
			
	

	try {

		preparedStatement = con.prepareStatement(sql);
			
	  preparedStatement.execute();
	  
	  
	  
	  preparedStatementent=con.prepareStatement("ALTER TABLE accountentry AUTO_INCREMENT=10");
		preparedStatementent.execute();
		
		String sql1 = "INSERT INTO accountentry (date, amount, description, accounID)"+
			    " VALUES (?,?,?,?);";
		preparedStatement1 = con.prepareStatement(sql1);
		preparedStatement1.setDate(1, java.sql.Date.valueOf(account.getAccountEntry().getDate()));
		preparedStatement1.setString(2, account.getAccountEntry().getAmount().toString());
		preparedStatement1.setString(3, account.getAccountEntry().getDescription());
		preparedStatement1.setInt(4, Integer.parseInt(account.getAccountNumber()));
		preparedStatement1.execute();


	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
		log();
	}

	@Override
	public Account loadAccount(String accountNumber) {
	
		
		
//		customer=CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
//		Address address= new Address();
//		customer.setAddress(address);
//		account=accountFactory.createAccount(BankAccountType.CHECKING);
//		account.setCustomer(customer);
		Account account1=null;
		try {
			account1 = account.getclone(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT  a.accountNumber, a.balance, a.accountType, b.name, b.email, c.street, c.city, c.zip, c.state "+
               "FROM customer b "+
        "INNER JOIN address c "+
            "ON b.addressID = c.ID "+
        "INNER JOIN account a "+
           "ON b.ID = a.CustomerID "+
		"WHERE   a.accountNumber = "+accountNumber+";" ;
		PreparedStatement preparedStatement;



try {

	preparedStatement = con.prepareStatement(sql);
	
	
    ResultSet rs=preparedStatement.executeQuery();


    while ( rs.next() ) {
    	account1.setAccountNumber(Integer.toString(rs.getInt(1)));
    	account1.setBalance((double) rs.getInt(2));
    	AccountType accty=BankAccountType.CHECKING;
    	if("SAVING".equalsIgnoreCase(rs.getString(3))){
    		accty=BankAccountType.SAVING;
    	}
    	account1.setAccountType(accty);
    	account1.getCustomer().setName(rs.getString(4));
    	account1.getCustomer().setEmail(rs.getString(5));
    	account1.getCustomer().getAddress().setStreet(rs.getString(6));
    	account1.getCustomer().getAddress().setCity(rs.getString(7));
    	account1.getCustomer().getAddress().setZip(rs.getString(8));
    	account1.getCustomer().getAddress().setState(rs.getString(9));
    	account1.setAccountEntries(getAccountEntry(accountNumber));
    	
        System.out.println(account1);
        
    }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("Connection Failed! Check output console");
	e.printStackTrace();
}
log();

      
return account1;
	}

	@Override
	public Collection<Account> getAccounts() {
		
		
		String sql = "SELECT  a.accountNumber, a.balance, b.name, b.email, c.street, c.city, c.zip, c.state "+
               "FROM    customer b "+
        "INNER JOIN address c "+
            "ON b.addressID = c.ID "+
        "INNER JOIN account a "+
           "ON b.ID = a.CustomerID ; ";
		PreparedStatement preparedStatement;



try {

	preparedStatement = con.prepareStatement(sql);
	
	
    ResultSet rs=preparedStatement.executeQuery();

    while ( rs.next() ) {
//    	customer=CustomerFactory.createCustomer(CustomerType.INDIVIDUAL);
//		Address address= new Address();
//		customer.setAddress(address);
//		account=accountFactory.createAccount(BankAccountType.CHECKING);
//		account.setCus;tomer(customer);
       Account account1=null;
	try {
		account1 = account.getclone(account);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	account1.setAccountNumber(Integer.toString(rs.getInt(1)));
    	account1.setBalance((double) rs.getInt(2));
    	account1.getCustomer().setName(rs.getString(3));
    	account1.getCustomer().setEmail(rs.getString(4));
    	account1.getCustomer().getAddress().setStreet(rs.getString(5));
    	account1.getCustomer().getAddress().setCity(rs.getString(6));
    	account1.getCustomer().getAddress().setZip(rs.getString(7));
    	account1.getCustomer().getAddress().setState(rs.getString(8));
    	accountlist.add(account1);
    
        System.out.println(account1);
        
    }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("Connection Failed! Check output console");
	e.printStackTrace();
}
log();




return accountlist;
	}
	
	public void log(){
		System.out.println();
		System.out.println("start logging");
		
	}

	@Override
	public void saveBankStaff(BankStaff bankStaff) {

		System.out.println(bankStaff);
		
		String sql = "INSERT INTO bankstaff (username, pwd, fname, lname, age, gender)"+
					    " VALUES (?,?,?,?,?,?);";
		
		
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = con.prepareStatement(sql);
			
			
			preparedStatement.setString(1, bankStaff.getUsername());
			preparedStatement.setString(2, bankStaff.getPwd());
			preparedStatement.setString(3, bankStaff.getFname());
			preparedStatement.setString(4, bankStaff.getLname());
			preparedStatement.setInt(5, bankStaff.getAge());
			preparedStatement.setString(6, bankStaff.getGender());
		
			preparedStatement.execute();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		log();
	}

	@Override
	public List<BankStaff> getBankStaff() {
		String sql = "SELECT  a.fname, a.gender, a.lname, a.pwd, a.username, a.age"+
	               " FROM    bankstaff a ;";
	        
			PreparedStatement preparedStatement;



	try {

		preparedStatement = con.prepareStatement(sql);
		
		
	    ResultSet rs=preparedStatement.executeQuery();

	    while ( rs.next() ) {
	    	bankstaff=new BankStaff();
	    	
	    	bankstaff.setFname(rs.getString(1));
	    	bankstaff.setGender(rs.getString(2));
	    	bankstaff.setLname(rs.getString(3));
	    	bankstaff.setPwd(rs.getString(4));
	    	bankstaff.setUsername(rs.getString(5));
	    	bankstaff.setAge(Integer.parseInt(rs.getString(6)));
	    	stafflist.add(bankstaff);
	    
	        System.out.println(bankstaff);
	        
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
	return stafflist;
	

	}

	@Override
	public Account getAccountHashmap(String accnum) {
		// TODO Auto-generated method stub
		return dataMap.get(accnum);
	}

	@Override
	public void updateAccountHashmap(Account acc) {
		// TODO Auto-generated method stub
		dataMap.put(acc.getAccountNumber(), acc);
	}

	@Override
	public Collection<Account> getAccountsHashmap() {
		// TODO Auto-generated method stub
		return dataMap.values();
	}
	
	private List<AccountEntry> getAccountEntry(String accn){
		
		List<AccountEntry> listofaccentry=new ArrayList<AccountEntry>();
		String sql = "SELECT  a.date, a.amount, a.description, a.accounID"+
	               " FROM    accountentry a where a.accounID="+accn+";";
	        
			PreparedStatement preparedStatement;



	try {

		preparedStatement = con.prepareStatement(sql);
		
		
	    ResultSet rs=preparedStatement.executeQuery();

	    while ( rs.next() ) {
	    	AccountEntry accentry=new AccountEntryImp();
	    	
//	    	accentry.setDate(rs.getDate(1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	    	accentry.setAmount(Double.parseDouble(rs.getString(2)));
	    	accentry.setDescription(rs.getString(3));
	    	
	    	
	    	listofaccentry.add(accentry);
	    
	        System.out.println(accentry);
	        
	    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
	return listofaccentry;
	}

}
