package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.service.FileService;
import reactor.core.publisher.Flux;

@RestController
public class FileInputController {
    private FileService service;

    @Autowired
    public FileInputController(FileService service) {
        this.service = service;
    }

    @GetMapping(value = "/{word}", produces = MediaType.TEXT_HTML_VALUE)
    public Flux<String> getFile(@RequestParam String link, @PathVariable String word) {
        return service.getStringsByTemplates(link, word);
    }
}
