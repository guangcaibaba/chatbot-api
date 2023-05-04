package domain.zsxq.model.res;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：AnswerResp
 * @Date：2023/5/4 15:23
 * @description：请求问答接口结果
 */
public class AnswerRes {
    private boolean succeeded;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
}
