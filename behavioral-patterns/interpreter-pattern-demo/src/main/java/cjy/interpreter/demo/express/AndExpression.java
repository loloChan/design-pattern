package cjy.interpreter.demo.express;

/**
 * 组合表达式
 */
public class AndExpression implements Expression{

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expression1 = expr1;
        this.expression2 = expr2;
    }


    /**
     * 对某一字符串进行解释
     *
     * @param context
     * @return
     */
    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) &&
                expression2.interpret(context);
    }
}
