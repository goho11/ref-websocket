package co.kr.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/save-form")
    public String saveForm(){
        return "save-form";
    }

    @GetMapping("/api")
    public ResponseEntity<?> api(){
        List<Chat> models = chatService.findAll();
        return ResponseEntity.ok(models);
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
