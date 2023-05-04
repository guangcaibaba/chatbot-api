package domain.ai.model.aggregates;

import domain.ai.model.vo.Choices;
import lombok.Data;

import java.util.List;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：AIAnswer
 * @Date：2023/5/4 17:13
 * @description：AI回答
 */
@Data
public class AIAnswer {
    private String id;
    private String object;
    private int created;
    private String model;
    private List<Choices> choices;
}
