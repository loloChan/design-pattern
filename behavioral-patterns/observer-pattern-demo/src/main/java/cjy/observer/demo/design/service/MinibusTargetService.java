package cjy.observer.demo.design.service;

/**
 * 小汽车摇号服务
 */
public class MinibusTargetService {

    /**
     * 模拟摇号
     * @param uid 用户编号
     * @return
     */
    public String lottery(String uid) {

        //模拟摇号算法
        boolean flag = Math.abs(uid.hashCode()) % 2 == 0;
        String result = "";
        if (flag) {
            result = "恭喜你，编码 " + uid + " 在本次摇号中中签了！";
        } else {
            result = "很遗憾，编码 " + uid + " 在本次摇号中未中签或摇号资格已过期。";
        }
        return result;
    }

}
