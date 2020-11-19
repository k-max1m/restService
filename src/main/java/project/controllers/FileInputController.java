package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.service.FileService;

import java.util.Base64;
import java.util.List;

@RestController
public class FileInputController {
    private FileService service;

    @Autowired
    public FileInputController(FileService service) {
        this.service = service;
    }

    @GetMapping("/{word}")
    public List<String> getFile(@RequestParam String link, @PathVariable String word) {
        Base64.Decoder decoder = Base64.getDecoder();
        String decodeLink = new String(decoder.decode(link));
        String decodeWord = new String(decoder.decode(word));
        service.getAllAndSort().forEach(System.out::println);
        return service.getStringsByTemplates(decodeLink, decodeWord);
    }
}
