package ru.rightcode.rightcoderestservice.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ru.rightcode.rightcoderestservice.model.Article;
@Component
public class ArticleModelAssembler implements RepresentationModelAssembler<Article, EntityModel<Article>>{
    @Override
    public EntityModel<Article> toModel(Article article) {
        return EntityModel.of(article);
    }

}
