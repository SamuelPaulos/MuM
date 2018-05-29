package framework.service;

import framework.entity.Account;
import framework.observer.Observer;

public class SendEmailmp implements Observer {
	private AccountServiceObservableProxy accountService;
	
	public SendEmailmp(AccountServiceObservableProxy accountService) {
		super();
		this.accountService = accountService;
		//accountService.registerObserver(this);
	}

	public void sendEmail() {
		Account account = accountService.getAccount("accountNumber");
		System.out.println("send email Account created");
	}

	@Override
	public void update() {
		sendEmail();
	}

}
