package cjy.bridge.demo.design.mode;

/**
 * 支付验证方式
 */
public interface PayMode {

    /**
     * 安全验证
     * @return
     */
    boolean security();

}
