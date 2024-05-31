package cn.orient.controller;

import cn.orient.config.Result;
import cn.orient.entity.UserInput;
import cn.orient.service.AiGenerateService;
import cn.orient.service.impl.AIGenerationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2na1ve
 */
@RestController
@Slf4j
public class AiGenerationController {

    @PostMapping("/tableGenertor")
    public Result tableGenerate(@RequestBody UserInput userInput) {
        AiGenerateService generateService = new AIGenerationServiceImpl();
        String table = null;
        if (userInput.getUserInput() != null) {
            try {
                table = generateService.generateTable(userInput.getUserInput()) + "</table>";
            } catch (Exception e) {
                return Result.fail(e.getMessage());
            }

            if (table != null) {
                log.info("Generate Success: {}", table);
                return Result.success(table);
            }

            return Result.fail("Table Generate Error");
        }
        return Result.fail("Table Generate Error");
    }

    @PostMapping("/articleGenerate")
    public Result articleGenerate(@RequestBody UserInput userInput) {
        AiGenerateService generateService = new AIGenerationServiceImpl();
        String article = null;

        if (userInput.getUserInput() != null) {
            try{
                article = generateService.generateAtricle(userInput.getUserInput());
                if (article.contains("<body>")){
                    article = article.replaceAll("<body>","<div>") +"</div>";
                }
            }catch (Exception e){
                return Result.fail(e.getMessage());
            }
            if (article != null) {
                log.info("Generate Success: {}", article);
                return Result.success(article);
            }
            return Result.fail("Article Generate Error");
        }
        return Result.fail("Article Generate Error");
    }
}
