package controllers;

import domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CommentService;

import java.util.*;

/**
 * Created by Alexey Samoylov on 14.01.2015.
 */

@Controller

public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("page1", "command", new MyText());
        modelAndView.addObject("message", "Hello world!"); // обычная строка
        return modelAndView;
    }

    @RequestMapping(value="/page2", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("myText", new MyText());
        return "page2";
    }

    @RequestMapping(value="/page2", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute("myText") MyText myText, Model model) {
        model.addAttribute("myText", myText); // свой объект
        return "page2";
    }

    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public ModelAndView page1() {
        ModelAndView modelAndView = new ModelAndView("page1", "command", new MyText());
        modelAndView.addObject("message", "Hello world!");
        return modelAndView;
    }

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/comment")
   public String greetingSubmit(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.listComment());
        return "comment";
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody Comment addContact(@RequestBody Comment comment){
        System.out.println( comment );
        commentService.addComment(comment);
        comment.setId(commentService.getID(comment));
        return comment;
    }


    @RequestMapping("comment/delete")
    public @ResponseBody
    List<Comment> deleteContact(@RequestBody Integer commentId) {

        commentService.removeComment(commentId);


        return  commentService.listComment();
    }

}