package fr.inria.lille.repair.nopol.spoon.smt;

import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;

public class ConditionalReplacer extends ConditionalProcessor {

	public ConditionalReplacer(CtStatement target) {
		super(target, ((CtIf) target).getCondition().toString());
	}
	
	@Override
	public CtIf processCondition(CtStatement element, String newCondition) {
		CtCodeSnippetExpression<Boolean> snippet = element.getFactory().Core().createCodeSnippetExpression();
		snippet.setValue(newCondition);
		CtExpression<Boolean> condition = getCondition(element);
		condition.replace(snippet);
		return (CtIf) element;
	}
}