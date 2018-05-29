package framework.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

public abstract class FormRuleProcessor {
	protected static Map<String, String> reqFieldsMap = new HashMap<>();
	protected static Map<String, String> emptyFieldsMap = new HashMap<>();
	protected static Map<String, String> numFieldsMap = new HashMap<>();
	protected static List<JTextField> txtFieldList = new ArrayList<>();
	
	protected FormRuleProcessor successor;
	public void setSuccessor( FormRuleProcessor handler) {
		successor  = handler;
	}

	public abstract void handleRequest( Class<?> ruleClass , StringBuilder validationErrStr);
	
	public void processRequest(Class<?> ruleClass , StringBuilder validationErrStr ){
		ValidationChainBuilder.getHandler().handleRequest( ruleClass , validationErrStr );
	}
	
	public static void populatetxtFieldList( List<JTextField> lst ) {
		txtFieldList  = lst;
	}
}
