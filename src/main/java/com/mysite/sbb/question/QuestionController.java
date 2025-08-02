package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        //조회한 질문 리스트(questionList)를 모델에 "questionList"라는 이름으로 추가-> 뷰에서 ${questionList}로 접근가능
        model.addAttribute("questionList", questionList);
        return "question_List";
    }

    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
