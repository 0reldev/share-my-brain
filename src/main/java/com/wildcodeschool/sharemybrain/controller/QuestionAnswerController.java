package com.wildcodeschool.sharemybrain.controller;


import com.wildcodeschool.sharemybrain.entity.Answer;
import com.wildcodeschool.sharemybrain.entity.Avatar;
import com.wildcodeschool.sharemybrain.entity.Question;
import com.wildcodeschool.sharemybrain.repository.AvatarRepository;

import com.wildcodeschool.sharemybrain.repository.AnswerRepository;
import com.wildcodeschool.sharemybrain.repository.QuestionRepository;
import com.wildcodeschool.sharemybrain.repository.SkillRepository;
import com.wildcodeschool.sharemybrain.repository.UserRepository;

import org.graalvm.compiler.core.CompilationWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class QuestionAnswerController {

    private final QuestionRepository questionRepository = new QuestionRepository();
    private final SkillRepository skillRepository = new SkillRepository();
    private final UserRepository userRepository = new UserRepository();
    private final AvatarRepository avatarRepository = new AvatarRepository();
    private final AnswerRepository answerRepository = new AnswerRepository();
    private UserRepository repository = new UserRepository();

    @GetMapping("/questions")
    public String share(Model model, @RequestParam(required = false, defaultValue = "1") int page,
                        @CookieValue(value = "username", defaultValue = "Atta") String username) {
        if (username.equals("Atta")) {
            return "/error";
        }
        int question_offset, limit;
        limit = 3;
        question_offset = (page * limit) - limit;
        int idSkill = userRepository.findSkill(username);
        int qtyQuestions = questionRepository.totalLines(idSkill);
        int numPages = (int) Math.ceil((double) qtyQuestions / limit);
        if (question_offset + limit > qtyQuestions) {
            limit = qtyQuestions - question_offset;
        }

        model.addAttribute("page", page);
        model.addAttribute("numPages", numPages);
        if (idSkill == -1) {

            model.addAttribute("questions", questionRepository.findWithLimit(limit, question_offset));
        } else {
            List<Question> questions = questionRepository.findWithSkill(limit, question_offset, idSkill);
            Map<Question, Avatar> avatarQuestMap = new LinkedHashMap<>();
            int avatarId;
            for (Question question : questions) {
                avatarId = userRepository.findAvatarById(question.getIdUser());
                avatarQuestMap.put(question, avatarRepository.findAvatar(avatarId));
                question.setCountAnswers(answerRepository.countAnswersByQuestion(question.getIdQuestion()));
            }
            model.addAttribute("avatarQuestMap", avatarQuestMap);
        }

        int idAvatar = userRepository.findAvatar(username);
        model.addAttribute("username", username);

        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());

        return "/questions";
    }


    @GetMapping("/ask")
    public String ask(Model model, @CookieValue(value = "username", defaultValue = "Atta") String username) {
        if (username.equals("Atta")) {
            return "/error";
        }
        model.addAttribute("skills", skillRepository.findAllSkills());
        int idAvatar = userRepository.findAvatar(username);
        model.addAttribute("username", username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());
        return "/askquestion";
    }

    @GetMapping("/answer/{question}")
    public String answer(Model model, @PathVariable int question, @CookieValue(value = "username", defaultValue = "Atta") String username) {
        if (username.equals("Atta")) {
            return "/error";
        }
        int idAvatar = userRepository.findAvatar(username);
        model.addAttribute("username", username);
        model.addAttribute("avatar", avatarRepository.findAvatar(idAvatar).getUrl());
        Question questionDescr = questionRepository.findQuestion(question);
        int avatarId = userRepository.findAvatarById(questionDescr.getIdUser());
        model.addAttribute("avatarQ", avatarRepository.findAvatar(avatarId));
        model.addAttribute("question", questionDescr);
        model.addAttribute("answers", answerRepository.findAnswerWithId(question));
        List<Answer> answers = answerRepository.findAnswerWithId(question);
        Map<Answer, Avatar> avatarAnswerMap = new LinkedHashMap<>();
        int avatarAnswerId;
        for (Answer answer : answers){
            avatarAnswerId = repository.findAvatarById(answer.getIdUser());
            avatarAnswerMap.put(answer, avatarRepository.findAvatar(avatarAnswerId));
        }
        model.addAttribute("avatarAnswerMap", avatarAnswerMap);
        return "/answerquestion";
    }

    @PostMapping("/answerquestion")
    public String postAnswer(@RequestParam int idQuestion,
                             @RequestParam(required = true) String answerQuestion,
                             @CookieValue(value = "username", defaultValue = "Atta") String username) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        int idUser = userRepository.findUserId(username);
        answerRepository.answerQuestion(idQuestion, idUser, answerQuestion, sdf.format(date));
        return "redirect:/questions";
    }

    @PostMapping("/askquestion")
    public String postAnswer(@RequestParam String question_title,
                             @RequestParam int idSkill,
                             @RequestParam String question,
                             @CookieValue(value = "username", defaultValue = "Atta") String username){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        int idUser = userRepository.findUserId(username);
        questionRepository.askQuestion(question_title, question, sdf.format(date), idUser, idSkill);
        return "redirect:/" ;
    }
}

