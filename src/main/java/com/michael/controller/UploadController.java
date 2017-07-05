package com.michael.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michael.storage.FileStorageService;


@Controller
public class UploadController {
	
	private final FileStorageService storageService;
	
    @Autowired
    public UploadController(FileStorageService storageService) {
        this.storageService = storageService;
    }
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException{
		
			storageService.saveUploadedFiles(file);
	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded " + file.getOriginalFilename() + "!");

	        return "redirect:/";
	}
	
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll());
        return "uploadForm";
    }
    
}
