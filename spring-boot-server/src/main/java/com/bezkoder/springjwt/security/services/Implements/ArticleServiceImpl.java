package com.bezkoder.springjwt.security.services.Implements;

import com.bezkoder.springjwt.models.Article;
import com.bezkoder.springjwt.repository.ArticleRepository;
import com.bezkoder.springjwt.security.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void createArticle(Article article) {
        Article article1 = new Article();

        article1.setTitle(article.getTitle());
        article1.setContenu(article.getContenu());
        articleRepository.save(article1);

    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).isPresent() ? articleRepository.findById(id).get() : null ;
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public void updateArticle(Long id, Article article) {
        Article article1 = articleRepository.findById(id).isPresent() ? articleRepository.findById(id).get() : null ;
        article1.setTitle(article.getTitle());
        article1.setContenu(article.getContenu());
        articleRepository.save(article1);
    }

    @Override
    public void delete(Long id) {
        Article article1 = articleRepository.findById(id).isPresent() ? articleRepository.findById(id).get() : null ;
        articleRepository.delete(article1);
    }
}
