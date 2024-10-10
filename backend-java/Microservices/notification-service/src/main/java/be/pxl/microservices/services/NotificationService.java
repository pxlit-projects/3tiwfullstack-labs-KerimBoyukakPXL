package be.pxl.microservices.services;

import be.pxl.microservices.domain.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendMessage(Notification notification){
//        log.info("Receiving notification...");
//        log.info("Sending...{}", notification.getMessage());
//        log.info("To...{}", notification.getSender());
        System.out.println("Receiving notification...");
        System.out.println("Sending " + notification.getMessage());
        System.out.println("To " + notification.getSender());
    }
}
