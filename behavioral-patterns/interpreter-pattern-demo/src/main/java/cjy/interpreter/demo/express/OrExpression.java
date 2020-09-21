package cjy.interpreter.demo.express;

/**
 * or 组合表达式
 */
public class OrExpression implements Expression {

    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    /**
     * 对某一字符串进行解释
     *
     * @param context
     * @return
     */
    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) ||
                expr2.interpret(context);
    }
}
