package com.dnd.base.api.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultPage {
    private static final String SUCCESS = "00";
    private static final String FAIL = "01";
    private Page page;
    private String rspCode;
    private String rspMsg;

    public static ResultPage succeed(IPage page) {
        return new ResultPage(Page.ok(page), SUCCESS, null);
    }

    public static ResultPage succeed(String msg, IPage page) {
        return new ResultPage(Page.ok(page), SUCCESS, msg);
    }

    public static ResultPage failed() {
        return failedWith(null, FAIL, "调用失败");
    }

    public static ResultPage failed(String msg) {
        return failedWith(null, FAIL, msg);
    }

    public static ResultPage failed(IPage model, String msg) {
        return failedWith(model, FAIL, msg);
    }

    public static ResultPage failedWith(IPage datas, String code, String msg) {
        return new ResultPage(Page.fail(datas), code, msg);
    }
}
