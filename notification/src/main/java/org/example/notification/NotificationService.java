package org.example.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .sender("Amigoscode")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build()

        );

    }
}
