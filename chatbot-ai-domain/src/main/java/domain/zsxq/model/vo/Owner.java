package domain.zsxq.model.vo;

import lombok.Data;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：Owner
 * @Date：2023/5/4 14:52
 * @description：
 */
@Data
public class Owner {
    private String user_id;
    private String name;
    private String avatar_url;
    private String location;
}
