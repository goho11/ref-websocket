package co.kr.metacoding.refsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// 옵저버 패턴을 구현하지 않아도 알아서 해주게 만들기
// SRP: 마트 점원(메시지브로커) 세팅
@EnableWebSocketMessageBroker
@Configuration // IoC 띄우기
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 재정의
    // 웹소켓 연결 앤드포인트 설정 -어떤 주소를 치면 나오는지
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect")
                .setAllowedOriginPatterns("*"); // 모든 클라이언트 주소 허용
    }

    // 구독, 발행 앤드포인트 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); // sub로 시작하는 모든 주소 -구독
        registry.setApplicationDestinationPrefixes("/pub"); // pub로 시작하는 모든 주소 -발행
    }

}
