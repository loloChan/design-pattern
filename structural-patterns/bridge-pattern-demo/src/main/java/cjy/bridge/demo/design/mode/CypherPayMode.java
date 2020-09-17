package cjy.bridge.demo.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 密码支付
 */
public class CypherPayMode implements PayMode {

    private static Logger logger = LoggerFactory.getLogger(CypherPayMode.class);

    /**
     * 安全验证
     *
     * @return
     */
    public boolean security() {

        logger.info("密码支付，安全校验通过！");

        return true;
    }
}
