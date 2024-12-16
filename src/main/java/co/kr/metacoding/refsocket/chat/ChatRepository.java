package co.kr.metacoding.refsocket.chat;

import org.springframework.data.jpa.repository.JpaRepository;

// <엔티티 이름, 프라이머리 키>
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
