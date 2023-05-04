package domain.zsxq.model.req;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：ReqData
 * @Date：2023/5/4 15:04
 * @description：请求对象
 */
@Data
public class ReqData {
    private String text;
    private String[] image_ids = new String[]{};
    private boolean silenced;

    public ReqData(String text, boolean silenced){
        this.text = text;
        this.silenced = silenced;
    }
}
