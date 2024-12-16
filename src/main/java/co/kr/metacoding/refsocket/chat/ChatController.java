package co.kr.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/save-form")
    public String saveForm(){
        return "save-form";
    }

    @GetMapping("/")
    public String index(Model model) { // model에 담아서 쓰려고 만듬
        model.addAttribute("models", chatService.findAll());

        return "index";
    }

    @PostMapping("/chat")
    public String save(String msg) {
        chatService.save(msg);
        return "redirect:/";
    }
}
