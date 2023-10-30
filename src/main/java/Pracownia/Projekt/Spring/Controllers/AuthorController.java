package Pracownia.Projekt.Spring.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "author")
@RequestMapping("/author")
public class AuthorController {
}
