package framework.dao;

import java.util.ArrayList;
import java.util.List;

import banking.entity.BankStaff;
import creditCard.entity.CreditStaff;
import framework.entity.Staff;
import framework.iterator.Aggregate;
import framework.iterator.Iterator;

public class StaffDataBase implements Aggregate {
	private static StaffDataBase staffDBInstance = new StaffDataBase();
	private static List<BankStaff> bankStaff;
	private static List<CreditStaff> creditStaff;
	private static AccountDAO accountdao=new AccountDAOImp();

	private StaffDataBase() {
		// creating a bank staff
		//bankStaff = new ArrayList<>();
//		BankStaff bs = new BankStaff();
//
//		bs.setFname("bank");
//		bs.setLname("bank");
//		bs.setAge(40);
//		bs.setGender("Male");
//		bs.setPassword("st");
//		bs.setUsername("st");
//
//		bankStaff.add(bs);
//
//		// creating a credit staff
//		creditStaff = new ArrayList<>();
//		CreditStaff cs = new CreditStaff();
//
//		cs.setFname("credit");
//		cs.setLname("credit");
//		cs.setAge(40);
//		cs.setGender("Male");
//		cs.setPassword("st");
//		cs.setUsername("st");
//		creditStaff.add(cs);
		
		//import all staffs from database
		
//		bankStaff = accountdao.getBankStaff();
	}

	@Override
	public Iterator getIterator(String staffType) {
		if (staffType.equals("bankStaff"))
			return new BankStaffIterator();
		else
			return new CreditStaffIterator();
	}

	// Bank staff iterator
	private class BankStaffIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {

			if (index < bankStaff.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Staff next() {

			while (this.hasNext()) {
				return bankStaff.get(index++);
			}

			return null;
		}
	}

	// Credit staff iterator
	private class CreditStaffIterator implements Iterator {

		int index;

		@Override
		public boolean hasNext() {

			if (index < creditStaff.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Staff next() {

			while (this.hasNext()) {
				return creditStaff.get(index++);
			}

			return null;
		}
	}


	public static List<BankStaff> getBankStaff() {
		
		
		return bankStaff;
	}

	public static void setBankStaff(List<BankStaff> bankStaff) {
		StaffDataBase.bankStaff = bankStaff;
	}

	public static List<CreditStaff> getCreditStaff() {
		return creditStaff;
	}

	public static void setCreditStaff(List<CreditStaff> creditStaff) {
		StaffDataBase.creditStaff = creditStaff;
	}

	public static StaffDataBase getStaffDBInstance() {
		bankStaff = accountdao.getBankStaff();
		return staffDBInstance;
	}

	public static void addBankStaff(BankStaff staff) {
		//bankStaff.add(staff);
		
		accountdao.saveBankStaff(staff);
	}

	public static void addCreditStaff(CreditStaff staff) {
		creditStaff.add(staff);
	}
}
