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


public abstract class FormValidator2 {

	private static Map<String, String> reqFieldsMap = new HashMap<>();
	private static Map<String, String> emptyFieldsMap = new HashMap<>();
	private static Map<String, String> numFieldsMap = new HashMap<>();
	protected static List<JTextField> txtFieldList = new ArrayList<>();
	protected JLabel validationResultLbl;
	
	
	public FormValidator2() {
		validationResultLbl = new JLabel();
		validationResultLbl.setForeground(Color.RED);
	}
	
	public void process( UserModel model ) {

      Class<?> obj = model.getClass();
      
      for (Field fld : obj.getDeclaredFields()) {
    	  
          Annotation annotation = fld.getAnnotation(Required.class);
          Annotation empty = fld.getAnnotation(Empty.class);
          Annotation num = fld.getAnnotation(Number.class);

          if (annotation instanceof Required) {
              Required req = (Required) annotation;

              if (req.required()) {

                  reqFieldsMap.put(req.name(), req.value());
              }

          } 
          if (empty instanceof Empty) {
              Empty field = (Empty) empty;

              if (field.isEmpty()) {
                  emptyFieldsMap.put(field.name(), field.value());
              }

          } 
          if (num instanceof Number) {
              Number numFld = (Number) num;

              if (numFld.isNumber()) {
                  numFieldsMap.put(numFld.name(), numFld.value());
              }

          }

      }
     
      displayErrorMsg();
      
  }
	
	private void displayErrorMsg() { 
	       
        StringBuilder build = new StringBuilder();

        build.append("<html>");
        for( JTextField txtField : txtFieldList ) {   
            if( reqFieldsMap.containsKey(txtField.getName())) {
                String msg = getErrRequiredStr(txtField).equals("") ? "": getErrRequiredStr(txtField)+"<br>";
                build.append( msg );
                
            } 
            else if( emptyFieldsMap.containsKey(txtField.getName()) ) {
                String msg = getErrEmptyStr(txtField).equals("") ? "": getErrEmptyStr(txtField)+"<br>";
                build.append( msg);
            }
            if( numFieldsMap.containsKey(txtField.getName()) ) {
                String msg = getErrNumber(txtField).equals("") ? "": getErrNumber(txtField)+"<br>";
                build.append( msg );
            }
        
        }
        
         build.append("</html>");
        
        validationResultLbl.setText(build.toString());
    }
    
  
	public void regiterTextField(JTextField txtField){
 	   
        txtFieldList.add(txtField);
    }
	
    public String getErrEmptyStr( JTextField txtField ) {
    
        String str = "";
         if (txtField instanceof JPasswordField) {
            JPasswordField pwdField = (JPasswordField) txtField;
            if( pwdField.getPassword().length == 0 ) 
                str = emptyFieldsMap.get(txtField.getName());
                
        }
        else if(txtField.getText().equals(""))
           str = emptyFieldsMap.get(txtField.getName());
        
        return str;
    }

    private String getErrRequiredStr(final JTextField txtField ) {
        String str = "";
        if (txtField instanceof JPasswordField) {
            JPasswordField pwdField = (JPasswordField) txtField;
            if( pwdField.getPassword().length == 0 ) 
                str = reqFieldsMap.get(txtField.getName());
                
        }
              
        else if( txtField.getText().equals("") )
           str = reqFieldsMap.get(txtField.getName());
        
        return str;
    }

    private String getErrNumber(JTextField txtField) {
        String str = "";
                      
        if( !txtField.getText().equals("") && !txtField.getText().matches("\\d+"))
           str = numFieldsMap.get(txtField.getName());
        
        return str;
    }
    
    public static void refreshTxtFieldList(List<JTextField> txtFieldList) {
		FormValidator2.txtFieldList = txtFieldList;
	}

}
