package api.test;

import com.alibaba.fastjson.JSON;
import domain.ai.IOpenAI;
import domain.zsxq.IZsxqApi;
import domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：SpringBootRunTest
 * @Date：2023/5/4 15:29
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-ai.groupId}")
    private String groupId;
    @Value("${chatbot-ai.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zxsqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnswerQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();
            // 获取问题id，问题
            logger.info("topicId:{} text:{}",topicId,text);
            // 回答问题
            //zsxqApi.answer(groupId,cookie,topicId,text,false);
        }
    }

    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT("帮我写一个冒泡排序");
        logger.info("测试结果：{}",response);
    }
}
