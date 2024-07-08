package com.example.board_api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    PostController(){
        Post.posts.add(new Post("뭐뭐1", "hello world1"));
        Post.posts.add(new Post("뭐뭐2", "hello world2"));
        Post.posts.add(new Post("뭐뭐3", "hello world3"));
    }
    @PostMapping("/post/register1")
    @ResponseBody
    public String postRegister1(@RequestBody Post body){
        Post.posts.add(body);
        return "ok";
    }

    @PostMapping("/post/register2")
    @ResponseBody
    public String postRegister2(Post body){
        Post.posts.add(body);
        return "ok";
    }
    @GetMapping("/post/list")
    @ResponseBody
    public List<Post> postList(){
        return Post.posts;
    }
    @GetMapping("/post/detail/{id}")
    @ResponseBody
    public Post postDetail(@PathVariable Long id) {
        for(Post a : Post.posts){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
    @GetMapping("/post/detailparam")
    @ResponseBody
    public Post postDetailParam(@RequestParam Long id) {
        for(Post a : Post.posts){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
}
