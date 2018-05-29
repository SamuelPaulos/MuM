package framework.validator;

import java.awt.Color;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public abstract class FormValidator {


	protected JLabel validationResultLbl;
	protected StringBuilder build = new StringBuilder("<html>");
	private static List<JTextField> txtFieldList = new ArrayList<>();
	
	
	public FormValidator() {
		validationResultLbl = new JLabel();
		validationResultLbl.setForeground(Color.RED);
	}
	
	public void process( UserModel model ) {

	      Class<?> ruleClass = model.getClass();
	      FormRuleProcessor.populatetxtFieldList(txtFieldList);
	      
	      ValidationChainBuilder.getHandler().processRequest(ruleClass, build);
	     
	      validationResultLbl.setText(build.append("</html>").toString());
      
    }
    
  
	public void regiterTextField(JTextField txtField){
 	   
        txtFieldList.add(txtField);
    }
	
	
    
    public static void refreshTxtFieldList(List<JTextField> txtFieldList) {
		FormValidator.txtFieldList = txtFieldList;
	}

}
