package framework.entity;

import java.io.Serializable;
import java.time.LocalDate;

public interface AccountEntry extends Serializable{

	LocalDate getDate();

	void setDate(LocalDate date);

	Double getAmount();

	void setAmount(Double amount);

	String getDescription();

	void setDescription(String description);

	String getFromAccountNumber();

	void setFromAccountNumber(String fromAccountNumber);

	String getFromPersonName();

	void setFromPersonName(String fromPersonName);

}