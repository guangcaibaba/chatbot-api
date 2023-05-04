package domain.zsxq.model.aggregates;

import domain.zsxq.model.res.RespData;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：UnAnswerQuestionsAggregates
 * @Date：2023/5/4 15:08
 * @description：未回答问题的聚合信息
 */
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
