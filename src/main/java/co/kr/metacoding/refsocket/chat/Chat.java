package co.kr.metacoding.refsocket.chat;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 폴링: 간혈적으로 리퀘스트 요청 - 반이중 방법
// 주기를 잘 잡는게 중요하다
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "chat_tb")
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String msg;

    @Builder
    public Chat(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }
}