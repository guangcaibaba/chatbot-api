package domain.zsxq.model.vo;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：Question
 * @Date：2023/5/4 14:52
 * @description：
 */
@Data
public class Question {
    private Owner owner;
    private Questionee questionee;
    private String text;
    private boolean expired;
    private boolean anonymous;
    private OwnerDetail ownerDetail;
    private String owner_location;
}
