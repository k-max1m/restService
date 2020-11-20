package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.DBEntity;
import project.repository.DBEntityRepository;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    private DBEntityRepository entityRepository;

    @Autowired
    public FileServiceImpl(DBEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Flux<String> getStringsByTemplates(String fileUrl, String word) {
        //                               то?link=D:\output.txt
        //0YfRgtC+?link=RDpcb3V0cHV0LnR4dA==          0YfRgtC+?link=C%3A%5CUsers%5C%D1%81%D1%82%D1%83%D0%B4%D0%B5%D0%BD%D1%8211%5CDesktop%5CMaksim+Kozlov+Q5.txt
        Date date = new Date();


        DBEntity entity = new DBEntity(fileUrl, word, date);

        Path path = Paths.get(fileUrl);
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            List<String> response = list.stream()
                    .filter(o -> o.toLowerCase().contains(word.toLowerCase()))
                    .collect(Collectors.toList());
            entityRepository.save(entity);
            return Flux.fromIterable(response);
        }
        else return null;
    }

    @Override
    public List<DBEntity> getAllAndSort(int start, int end) {
        return entityRepository.findAll().stream().sorted(Comparator.comparing(DBEntity::getDate)).collect(Collectors.toList()).subList(start,end);
    }
}
