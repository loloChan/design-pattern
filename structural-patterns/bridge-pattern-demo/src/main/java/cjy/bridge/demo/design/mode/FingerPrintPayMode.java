package cjy.bridge.demo.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 指纹支付
 */
public class FingerPrintPayMode implements PayMode{

    private static Logger logger = LoggerFactory.getLogger(FingerPrintPayMode.class);

    /**
     * 安全验证
     *
     * @return
     */
    public boolean security() {
        logger.info("指纹支付，安全验证通过！");
        return true;
    }
}
