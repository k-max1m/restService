package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.DBEntity;
import project.repository.DBEntityRepository;

import java.io.IOException;
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
    public List<String> getStringsByTemplates(String fileUrl, String word) {
        //D:\output.txt
        //0YfRgtC+?link=RDpcb3V0cHV0LnR4dA==
        Date date = new Date();


        DBEntity entity = new DBEntity(fileUrl, word, date);

        Path path = Paths.get(fileUrl);
        List<String> list = null;
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert list != null;
        List<String> response = list.stream()
                .filter(o -> o.contains(word))
                .collect(Collectors.toList());
        System.out.println(response.size());
        entityRepository.save(entity);
        return response;
    }

    @Override
    public List<DBEntity> getAllAndSort() {
        return entityRepository.findAll().stream().sorted(Comparator.comparing(DBEntity::getDate)).collect(Collectors.toList());
    }
}
