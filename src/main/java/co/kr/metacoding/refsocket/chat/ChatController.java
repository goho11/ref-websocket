package co.kr.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;
    private final SimpMessageSendingOperations sms;

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

    @GetMapping("/")
    public String index(Model model) { // model에 담아서 쓰려고 만듬
        model.addAttribute("models", chatService.findAll());

        return "index";
    }

    @PostMapping("/chat")
    public String save(String msg) {
        Chat chat = chatService.save(msg);
        sms.convertAndSend("/sub/chat" + chat);
        return "redirect:/";
    }

    // 요청하기 /pub/room
//    @MessageMapping("/room")
//    public void pubTest1(String number) {
//        System.out.println("나 요청돼? : " + number);
//        // /sub를 구독하는 자에게 메세지 전달
//        sms.convertAndSend("/sub" + number, "hello world" + number);
//    }

    // 방법2
//    @SendTo("/sub")
//    @MessageMapping("/room")
//    public String pubTest2(String number) {
//        System.out.println("나 요청돼? : " + number);
//        return "hello world";
//    }

}
