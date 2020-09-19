package cjy.facade.demo.design.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 白名单服务
 */
public class AuthService {

    /**
     * 白名单列表
     */
    private String whiteList;

    private Set<String> whiteSet;

    public AuthService(String whiteList) {
        this.whiteList = whiteList;
        whiteSet = new HashSet<>(Arrays.asList(split(",")));
    }

    public String[] split(String separatorChar) {
        return this.whiteList.split(separatorChar);
    }

    /**
     * 目标用户是否在白名单中
     * @param userId
     * @return
     */
    public boolean isWhiteList(String userId) {
        return whiteSet.contains(userId);
    }

}
