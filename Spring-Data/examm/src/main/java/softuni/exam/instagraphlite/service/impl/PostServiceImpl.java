package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PictureService pictureService;
    private final UserService userService;


    public PostServiceImpl(PostRepository postRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, PictureService pictureService, UserService userService) {
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.pictureService = pictureService;
        this.userService = userService;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();


        xmlParser.fromFile(FILE_PATH, PostRootDto.class)
                .getPosts()
                .stream()
                .filter(postDto -> {

                    boolean isValid = validationUtil.isValid(postDto)
                            && pictureService.doesEntityExist(postDto.getPicture().getPath())
                            && userService.doesEntityExist(postDto.getUser().getUsername());

                    sb.append(isValid ? String.format("Successfully imported Post, made by %s", postDto.getUser().getUsername())
                            : "Invalid Post").append(System.lineSeparator());

                    return isValid;
                }).map(postDto -> {

            Post post = modelMapper.map(postDto, Post.class);

            User user = userService.findByUsername(postDto.getUser().getUsername());
            post.setUser(user);

            post.setPicture(pictureService.findFirstByPath(postDto.getPicture().getPath()));

            return post;
        })
                .forEach(postRepository::save);

        return sb.toString();
    }
}
