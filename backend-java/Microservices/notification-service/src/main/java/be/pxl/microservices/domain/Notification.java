package be.pxl.microservices.domain;
import lombok.*;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String sender;    // 'from' is a reserved keyword in sql
    private String receiver;
    private String subject;
    private String message;
}
