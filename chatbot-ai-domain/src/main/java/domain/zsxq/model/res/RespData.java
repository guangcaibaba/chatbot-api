package domain.zsxq.model.res;

import domain.zsxq.model.vo.Topics;
import lombok.Data;

import java.util.List;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：RespData
 * @Date：2023/5/4 15:10
 * @description：结果数据
 */
@Data
public class RespData {
    private List<Topics> topics;
}
