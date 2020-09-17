package cjy.bridge.demo.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 刷脸支付
 */
public class FacePayMode implements PayMode {

    private static Logger logger = LoggerFactory.getLogger(FacePayMode.class);

    /**
     * 安全验证
     *
     * @return
     */
    public boolean security() {
        logger.info("刷脸支付，安全验证通过！");
        return true;
    }
}
