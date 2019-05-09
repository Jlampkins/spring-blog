package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
/****** this is dependency injection***************/
    private final PostRepository postCRUD;
    private final UserRepository userCRUD;
    private  EmailService emailService;

    public PostController(PostRepository posts, UserRepository user, EmailService emailService){
        this.postCRUD = posts;
        this.userCRUD = user;
        this.emailService = emailService;
    }
/**************************************************/
    @GetMapping("/posts")
    public String showPosts(Model viewModel){
        viewModel.addAttribute("posts", postCRUD.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToSave){
        User user = userCRUD.findOne(2L);
        postToSave.setUser(user);
        //you can obtain properties from a saved item
        Post savedPost = postCRUD.save(postToSave);
        //this will send an automated email when creating a post.
        emailService.prepareAndSend(savedPost, "Hello, Mother.  I have created an automated email system", "The post has been created successfully and you may find it with the ID of " + savedPost.getId());
        return "redirect:/posts/" + savedPost.getId();
    }


    @GetMapping("/posts/delete")
    @ResponseBody
    protected String deletePost(){
        return "please delete me.  end my suffering";
    }

    @GetMapping("/posts/delete/{id}")
    @ResponseBody
    protected String deletePost(@PathVariable long id){
        postCRUD.delete(id);
        return "The post has been deleted";
    }

//    @GetMapping("/posts/edit")
//    @ResponseBody
//    protected String editPost(){
//        return "Here are some posts to edit";
//    }

    @GetMapping("/posts/edit/{id}") //change this to post later
    protected String editPost(@PathVariable long id, Model model){
        Post post = postCRUD.findOne(id);
        model.addAttribute("post", post);
            return "/posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@ModelAttribute Post postToEdit){
        postToEdit.setUser(userCRUD.findOne(1L));
        postCRUD.save(postToEdit);
        return "redirect:/posts/" + postToEdit.getId();
    }


    @GetMapping("/posts/{id}")
    public String showIndivPost(@PathVariable long id, Model viewModel) {
        Post post = postCRUD.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/show";
    }












//    @PostMapping("/posts/email")
//    @ResponseBody
//    public String emailPost(EmailService emailService){
//        Post post = new Post();
//        post.setAuthorEmail("bethany1251@gmail.com");
//        post.setTitle("Here is post #" + post.getId());
//        post.setBody("Here is my garbage.  There are many like it. This one is mine");
//
//        this.emailService = emailService;
//        emailService.prepareAndSend(post);
//        return "success";
//    }



}
