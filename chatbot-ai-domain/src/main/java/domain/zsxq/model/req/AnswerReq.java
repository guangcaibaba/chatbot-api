package domain.zsxq.model.req;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：AnswerReq
 * @Date：2023/5/4 15:21
 * @description：请求问答接口
 */
@Data
public class AnswerReq {
    private ReqData req_data;

    public AnswerReq(ReqData req_data){
        this.req_data = req_data;
    }
}
