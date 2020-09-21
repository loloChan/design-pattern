package cjy.interpreter.demo.express;

/**
 * 表达式统一接口
 */
public interface Expression {

    /**
     * 对某一字符串进行解释
     * @param context
     * @return
     */
    boolean interpret(String context);

}
