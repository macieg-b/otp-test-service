package mba.otptestservice.services;


import mba.otptestservice.models.dbs.Sms;
import mba.otptestservice.repositories.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final SmsRepository smsRepository;

    @Autowired
    public SmsService(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    public void save(Sms sms) {
        smsRepository.save(sms);
    }
}
