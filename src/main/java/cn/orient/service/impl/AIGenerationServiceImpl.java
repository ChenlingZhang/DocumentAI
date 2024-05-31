package cn.orient.service.impl;

import cn.orient.service.AiGenerateService;
import cn.orient.utils.Json2String;
import cn.orient.utils.QWenConnector;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 2na1ve
 */
@Slf4j
public class AIGenerationServiceImpl implements AiGenerateService {

    private static final String API_KEY = "sk-1b6aef38091a491dbced1d583a25232d";

    @Override
    public String generateTable(String prompt) throws NoApiKeyException, ApiException, InputRequiredException {
        String userPrompt = "Please follow the user's request to generate a html code, only need return the html code, " +
                "the user's input may be in Chinese " + prompt;

        Constants.apiKey=API_KEY;
        QWenConnector qwenConnector = new QWenConnector();
        String jsonResult = qwenConnector.qWenStarter(userPrompt, 0.1f);
        log.info("The table generate by qwen is: {}", jsonResult);

        return Json2String.getHtmlTable(jsonResult);
    }

    @Override
    public String generateAtricle(String prompt) throws NoApiKeyException, ApiException, InputRequiredException {
        String userPrompt = "Please follow the user's request to generate an article, and form in an html code, all the style should be in the tag like <p style=''> only return the html code" +
                "the user's input may be in Chinese, here is the request: " + prompt;
        Constants.apiKey=API_KEY;
        QWenConnector qwenConnector = new QWenConnector();
        String jsonResult = qwenConnector.qWenStarter(userPrompt, 1.0f);
        log.info("The article generate by qwen is: {}", jsonResult);

        return Json2String.getHtmlArticle(jsonResult);
    }
}
