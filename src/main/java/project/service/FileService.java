package project.service;

import project.entity.DBEntity;

import java.util.List;

public interface FileService {
    List<String> getStringsByTemplates(String fileUrl, String word);
    List<DBEntity> getAllAndSort();
}
