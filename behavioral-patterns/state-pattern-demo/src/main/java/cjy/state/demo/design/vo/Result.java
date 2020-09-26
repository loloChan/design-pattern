package cjy.state.demo.design.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    /**
     * 状态码
     */
    private String state;

    /**
     * 信息
     */
    private String msg;

}
