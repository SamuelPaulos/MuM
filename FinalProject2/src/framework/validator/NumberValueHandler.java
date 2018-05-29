package framework.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.swing.JTextField;

public class NumberValueHandler extends FormRuleProcessor {

	@Override
	public void handleRequest(Class<?> ruleClass, StringBuilder build ) {

		for (Field fld : ruleClass.getDeclaredFields()) {

			Annotation num = fld.getAnnotation(Number.class);
			if (num instanceof Number) {
				Number numFld = (Number) num;

				if (numFld.isNumber()) {
					numFieldsMap.put(numFld.name(), numFld.value());
				}

			}
		}

		buildIsNotNumberFieldStr( build );

	}

	private void buildIsNotNumberFieldStr(StringBuilder build ) {
		for (JTextField txtField : txtFieldList) {
			if (numFieldsMap.containsKey(txtField.getName())) {
				String msg = getErrNumber(txtField).equals("") ? "" : getErrNumber(txtField) + "<br>";
			    build.append(msg);
			}
		}
	}

	private String getErrNumber(JTextField txtField) {

		String str = "";

		if (!txtField.getText().equals("") && !txtField.getText().matches("\\d+"))
			str = numFieldsMap.get(txtField.getName());

		return str;
	}

}
