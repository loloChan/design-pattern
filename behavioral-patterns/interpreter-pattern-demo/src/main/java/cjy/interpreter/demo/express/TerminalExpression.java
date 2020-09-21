package cjy.interpreter.demo.express;


/**
 * 上下文主要的解释器
 * 该解释器的主要作用：判断字符串context是否包含表达式固定的data字符串
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    /**
     * 对某一字符串进行解释
     *
     * @param context
     * @return
     */
    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
