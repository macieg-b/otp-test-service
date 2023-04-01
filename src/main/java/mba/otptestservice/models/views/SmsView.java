package mba.otptestservice.models.views;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsView {
    private String body;
    private String senderNumber;
}
