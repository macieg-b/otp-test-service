package mba.otptestservice.services;


import mba.otptestservice.models.dbs.Sms;
import mba.otptestservice.repositories.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SmsService {
    private final SmsRepository smsRepository;

    @Autowired
    public SmsService(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    public void save(Sms sms) {
        sms.setExtractedCode(extractCode(sms.getBody()));
        smsRepository.save(sms);
    }

    public Sms getLatest() {
        return smsRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
    }

    public List<Sms> getAll() {
        return smsRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDt"));
    }

    private String extractCode(String message) {
        Pattern pattern = Pattern.compile("[0-9]{4,}");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }
}
