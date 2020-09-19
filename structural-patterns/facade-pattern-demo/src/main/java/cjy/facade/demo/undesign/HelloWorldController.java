package cjy.facade.demo.undesign;

import cjy.facade.demo.vo.UserInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * 做白名单拦截，用一坨坨代码实现
 */
//@RestController
public class HelloWorldController {

    private static Set<String> authSet = new HashSet<String>();

    static {
        authSet.add("66715");
        authSet.add("99816");
        authSet.add("88618");
    }

    @RequestMapping(path = "/api/queryUserInfo/{userId}",method = RequestMethod.GET)
    public UserInfo queryUserInfo(@PathVariable String userId) {

        //白名单拦截

        if (!authSet.contains(userId)) {
            return new UserInfo("400", -1, "非白名单用户拦截！");
        }

        return new UserInfo("zhuzhu:" + userId, 18, "广州市");

    }

}
