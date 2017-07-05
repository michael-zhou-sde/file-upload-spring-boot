package com.michael.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.michael.model.MetaData;
import com.michael.model.MetaDataRepository;


@Service
public class FileStorageService {
	
	private final Path location = Paths.get("upload-dir"); 
	
	@Autowired
	private MetaDataRepository repo;
	
	public void saveUploadedFiles(MultipartFile file) throws IOException{
		if(file.isEmpty()) return;
		Files.copy(file.getInputStream(), location.resolve(file.getOriginalFilename()));
		MetaData meta = new MetaData(file.getOriginalFilename(), file.getSize()/1024 + "KB", LocalDateTime.now().toString());
		repo.save(meta);
	}

    public List<MetaData> loadAll() throws IOException {
    	List<MetaData> list = new ArrayList<>();
    	repo.findAll().forEach(list :: add);
    	if(list.size() > 0){
    		System.out.println(list.get(0).getFileName());
    	}
    	
    	return list;
    }
    
    public Path load(String filename) {
        return location.resolve(filename);
    }
	
    public void init() throws IOException {
    	FileSystemUtils.deleteRecursively(location.toFile());
    	if(! Files.exists(location))
    		Files.createDirectory(location);
    }
}
