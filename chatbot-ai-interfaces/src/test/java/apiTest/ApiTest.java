package apiTest;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：ApiTest
 * @Date：2023/5/4 10:27
 * @description：单元测试
 */
public class ApiTest {

    //查询未回答的问题
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/214218148858481/topics?scope=unanswered_questions&count=20");
        //get.addHeader("cookie","zsxq_access_token=C6162F14-290E-1EE7-3A79-43D1385F5E2C_B132ADDADB432A5E; abtest_env=product; zsxqsessionid=188f6353565e506df081db396f00bb44; UM_distinctid=187e4a896e2829-0bb3a13f1fa78d-7e57547f-384000-187e4a896e3eb3; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212528855282221%22%2C%22first_id%22%3A%22187e4a898f3d8c-0947914ffee053-7e57547f-3686400-187e4a898f4117d%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3ZTRhODk4ZjNkOGMtMDk0NzkxNGZmZWUwNTMtN2U1NzU0N2YtMzY4NjQwMC0xODdlNGE4OThmNDExN2QiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTI1Mjg4NTUyODIyMjEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212528855282221%22%7D%2C%22%24device_id%22%3A%22187e4a898f3d8c-0947914ffee053-7e57547f-3686400-187e4a898f4117d%22%7D");
        //get.addHeader("Content-Type","application/json;charset=utf8");
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48411118851818/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "知识星球个人cookie信息");
        get.addHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    //回答问题
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
        post.addHeader("cookie", "知识星球个人cookie信息");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
