package domain.ai;

import java.io.IOException;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：IOpenAI
 * @Date：2023/5/4 17:02
 * @description：chatgpt open ai 接口
 */
public interface IOpenAI {
    String doChatGPT(String question) throws IOException;
}
