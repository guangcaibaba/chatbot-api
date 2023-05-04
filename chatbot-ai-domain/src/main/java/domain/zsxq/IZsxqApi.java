package domain.zsxq;

import domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：ZsxqApi
 * @Date：2023/5/4 14:44
 * @description：
 */
public interface IZsxqApi {

    UnAnsweredQuestionsAggregates queryUnAnswerQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId,String cookie,String topicId,String text,boolean silenced) throws IOException;
}
