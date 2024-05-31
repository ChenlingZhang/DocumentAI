package cn.orient.utils;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 2na1ve
 */
@Slf4j
public class QWenConnector {

    public String qWenStarter(String prompt, float temperature) throws ApiException, NoApiKeyException, InputRequiredException {
      log.info("Current prompt is {}", prompt);

      Generation generation = new Generation();
      QwenParam param = QwenParam.builder()
              .model(Generation.Models.QWEN_TURBO)
              .prompt(prompt)
              .topP(0.8)
              .temperature(temperature)
              .build();
        GenerationResult result = generation.call(param);

        return JsonUtils.toJson(result);
    }
}
