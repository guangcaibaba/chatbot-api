package domain.zsxq.model.vo;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：Questionee
 * @Date：2023/5/4 14:53
 * @description：
 */
@Data
public class Questionee {
    private String user_id;
    private String name;
    private String avatar_url;
    private String description;
    private String location;
}
