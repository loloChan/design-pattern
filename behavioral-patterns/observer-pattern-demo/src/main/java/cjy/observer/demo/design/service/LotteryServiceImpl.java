package cjy.observer.demo.design.service;

import cjy.observer.demo.design.vo.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LotteryServiceImpl extends LotteryService {

    private static Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    /**
     * 摇号的具体实现
     *
     * @param uid
     * @return
     */
    @Override
    protected LotteryResult doDraw(String uid) {

        String lottery = minibusTargetService.lottery(uid);

        return new LotteryResult(uid,lottery);

    }
}
