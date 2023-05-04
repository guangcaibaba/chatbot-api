package application.job;

import com.alibaba.fastjson.JSON;
import domain.ai.IOpenAI;
import domain.zsxq.IZsxqApi;
import domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import domain.zsxq.model.vo.Topics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：ChatBotSchedule
 * @Date：2023/5/4 21:09
 * @description：
 */
@EnableScheduling
@Configuration
public class ChatBotSchedule {

    private Logger logger = LoggerFactory.getLogger(ChatBotSchedule.class);

    @Value("${chatbot-ai.groupId}")
    private String groupId;
    @Value("${chatbot-ai.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    // cron表达式网站:cron.qqe2.com
    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        try{
            // 生成随机情况
            if (new Random().nextBoolean()){
                logger.info("随机打烊中...");
                return;
            }

            // 判断是否在工作时间
            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7){
                logger.info("打烊时间不工作，AI下班了！");
            }

            // 1.检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnswerQuestionsTopicId(groupId, cookie);
            logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (null == topics || topics.isEmpty()){
                logger.info("本次检索未查询到待回答的问题");
                return;
            }
            // 2.AI回答
            Topics topic = topics.get(0);
            String answer = openAI.doChatGPT(topic.getQuestion().getText().trim());
            // 3.问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, false);
            logger.info("编号：{} 问题：{} 回答：{} 状态：{}",topic.getTopic_id(),topic.getQuestion().getText(),answer,status);
        } catch (Exception e) {
            logger.error("自动回答问题异常",e);
        }
    }

}
