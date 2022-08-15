package com.example.cloudinary.web;

import com.example.cloudinary.model.entity.PictureEntity;
import com.example.cloudinary.model.entity.binding.PictureBindingModel;
import com.example.cloudinary.model.view.PictureViewModel;
import com.example.cloudinary.repository.PictureRepository;
import com.example.cloudinary.service.CloudinaryImage;
import com.example.cloudinary.service.CloudinaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PictureController {

    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;

    public PictureController(CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }

    @GetMapping("/pictures/add")
    public String addPicture() {


        return "add";
    }

    @PostMapping("/pictures/add")
    public String addPictureConfirm(PictureBindingModel pictureBindingModel) throws IOException {

        var picture = createPictureEntity(pictureBindingModel.getPicture(), pictureBindingModel.getTitle());

        pictureRepository.save(picture);

        return "redirect:/pictures/all";
    }

    @GetMapping("/pictures/all")
    public String allPictures(Model model) {

        List<PictureViewModel> allPictures = pictureRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());

        model.addAttribute("pictures", allPictures);

        return "all";
    }

    private PictureViewModel map(PictureEntity pictureEntity){

        PictureViewModel pictureViewModel = new PictureViewModel();
        pictureViewModel.setTitle(pictureEntity.getTitle())
                .setUrl(pictureEntity.getUrl())
                .setPublicId(pictureEntity.getPublicId());

        return pictureViewModel;
    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {

        CloudinaryImage upload = cloudinaryService.upload(file);

        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setTitle(title)
                .setUrl(upload.getUrl());

    }

}
