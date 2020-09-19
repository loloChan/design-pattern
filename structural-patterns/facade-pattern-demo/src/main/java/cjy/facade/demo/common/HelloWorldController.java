package cjy.facade.demo.common;
import cjy.facade.demo.design.annotation.DoDoor;
import cjy.facade.demo.vo.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(path = "/api/queryUserInfo/{userId}",method = RequestMethod.GET)
    @DoDoor(key = "userId",returnJson = "{\"userId\":\"400\",\"age\":-1,\"address\":\"拦截非白名单用户\"}")
    public UserInfo queryUserInfo(@PathVariable String userId) {

        return new UserInfo("zhuzhu:" + userId, 18, "广州市");

    }

}
