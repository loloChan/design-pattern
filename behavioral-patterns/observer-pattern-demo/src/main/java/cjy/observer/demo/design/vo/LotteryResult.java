package cjy.observer.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotteryResult {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 结果
     */
    private String result;

}
