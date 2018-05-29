package framework.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EmptyValueHandler extends FormRuleProcessor {

	@Override
	public void handleRequest(Class<?> ruleClass, StringBuilder build) {

		for (Field fld : ruleClass.getDeclaredFields()) {

			Annotation annotation = fld.getAnnotation(Required.class);
			if (annotation instanceof Required) {
				Required req = (Required) annotation;

				if (req.required()) {

					reqFieldsMap.put(req.name(), req.value());
				}

			}
		}

		buildEmptyFieldStr(ruleClass, build);
		

	}

	private void buildEmptyFieldStr(Class<?> ruleClass, StringBuilder build) {

		for (JTextField txtField : txtFieldList) {
			if (emptyFieldsMap.containsKey(txtField.getName())) {
				String msg = getErrEmptyStr(txtField).equals("") ? "" : getErrEmptyStr(txtField) + "<br>";
				build.append(msg);
			} else {
				successor.handleRequest(ruleClass, build);
			}
		}
	}

	private String getErrEmptyStr(JTextField txtField) {

		String str = "";
		if (txtField instanceof JPasswordField) {
			JPasswordField pwdField = (JPasswordField) txtField;
			if (pwdField.getPassword().length == 0)
				str = emptyFieldsMap.get(txtField.getName());

		} else if (txtField.getText().equals(""))
			str = emptyFieldsMap.get(txtField.getName());

		return str;
	}

}
