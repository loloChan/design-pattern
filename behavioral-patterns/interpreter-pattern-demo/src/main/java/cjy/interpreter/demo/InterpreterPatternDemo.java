package cjy.interpreter.demo;

import cjy.interpreter.demo.express.AndExpression;
import cjy.interpreter.demo.express.Expression;
import cjy.interpreter.demo.express.OrExpression;
import cjy.interpreter.demo.express.TerminalExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterpreterPatternDemo {

    private static Logger logger = LoggerFactory.getLogger(InterpreterPatternDemo.class);

    public static void main(String[] args) {

        Expression andExpr = getAndKeyExpression("is", "a");
        Expression orExpr = getOrKeyExpression("hello", "nana");

        String context = "hello,xiaoming is a handsome boy!";

        logger.info("context:{} is contains keyword {} and {} ? {}", context, "\"is\"", "\"a\"", andExpr.interpret(context));
        logger.info("context:{} is contains keyword {} or {} ? {}", context, "\"hello\"", "\"nana\"", orExpr.interpret(context));

    }


    /**
     * 获取关键字 与 表达式
     * @param key1
     * @param key2
     * @return
     */
    public static Expression getAndKeyExpression(String key1,String key2) {

        Expression expr1 = new TerminalExpression(key1);
        Expression expr2 = new TerminalExpression(key2);

        Expression andExpr = new AndExpression(expr1, expr2);

        return andExpr;
    }

    /**
     * 获取关键字 或 表达式
     * @param key1
     * @param key2
     * @return
     */
    public static Expression getOrKeyExpression(String key1, String key2) {
        Expression expr1 = new TerminalExpression(key1);
        Expression expr2 = new TerminalExpression(key2);

        Expression orExpr = new OrExpression(expr1, expr2);
        return orExpr;
    }
}
