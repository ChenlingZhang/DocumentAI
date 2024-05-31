package cn.orient.service;

import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

/**
 * @author 2na1ve
 */
public interface AiGenerateService {

    public String generateTable(String prompt) throws NoApiKeyException, ApiException, InputRequiredException;

    public String generateAtricle(String prompt) throws NoApiKeyException, ApiException, InputRequiredException;
}
