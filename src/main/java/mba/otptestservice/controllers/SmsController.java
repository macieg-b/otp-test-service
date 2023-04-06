package mba.otptestservice.controllers;

import mba.otptestservice.models.dbs.Sms;
import mba.otptestservice.models.views.SmsView;
import mba.otptestservice.services.SmsService;
import mba.otptestservice.utilities.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@RequestBody SmsView smsView) {
        smsService.save(ModelMapper.convertToModel(smsView, Sms.class));
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping(value = "/newest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLatest() {
        Sms sms = smsService.getLatest();
        return ResponseEntity
                .ok(sms.getExtractedCode());
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SmsView>> getList() {
        List<Sms> smsList = smsService.getAll();
        return ResponseEntity
                .ok(smsList
                        .stream()
                        .map(sms -> ModelMapper.convertToView(sms, SmsView.class))
                        .collect(Collectors.toList())
                );
    }

}
