package zzz.yyy.xxx.demo.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import zzz.yyy.xxx.demo.application.resource.Response;
import zzz.yyy.xxx.demo.application.resource.TestBean;
import zzz.yyy.xxx.demo.domain.service.CommentService;

@RestController
@RequestMapping("api/comment")
@Slf4j
public class XxxController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/getcount")
    public ResponseEntity<Response<List<String>>> getMtNoteCount() {

        Response<List<String>> response = new Response<>();
        List<String> subInfo = commentService.getCount();
        response.setData(subInfo);

        log.debug("★response：" + response);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/findall")
    public ResponseEntity<Response<List<String>>> findAllPayment() {

        Response<List<String>> response = new Response<>();

        log.debug("★response：" + response);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "nagap", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getSomething() {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbb");
        list.add("ccccc");
        log.debug("★response：" + list);

        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "pathtest/{filename}")
    //    public String patTest(@RequestAttribute("bean") TestBean bean) {
    public String patTest(@ModelAttribute("bean") TestBean bean) {
        //log.debug("★fileName:" + fileName);
        log.debug("★bean:" + bean);
        log.debug("★bean.getFileName():" + bean.getFileName());

        return bean.getFileName();

    }

}
