package domain.ai.model.vo;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：Choices
 * @Date：2023/5/4 17:05
 * @description：选择
 */
@Data
public class Choices {
    private String text;
    private int index;
    private String logprobs;
    private String finish_reason;
}
