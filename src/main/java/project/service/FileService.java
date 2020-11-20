package project.service;

import project.entity.DBEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FileService {
    Flux<String> getStringsByTemplates(String fileUrl, String word);
    List<DBEntity> getAllAndSort(int start, int end);
}
