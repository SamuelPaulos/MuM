package framework.validator;

public class ValidationChainBuilder {

	public static FormRuleProcessor buildRoleHierarchy(){
		   
		   RequiredValidator reqValidtor = new RequiredValidator();
		   EmptyValueHandler emptyValidator = new EmptyValueHandler();
		   NumberValueHandler numberValidator = new NumberValueHandler();
		   
		   reqValidtor.setSuccessor(emptyValidator);  // validator.successor = washer;   alternative
		   emptyValidator.setSuccessor(numberValidator);
		   
		   return reqValidtor;
	   }
	   
	   public static FormRuleProcessor getHandler() {
		    
			
		    return buildRoleHierarchy();
   }
}
