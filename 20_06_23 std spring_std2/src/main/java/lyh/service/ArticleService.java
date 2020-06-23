package lyh.service;

import lyh.mapper.ArticleMapper;
import lyh.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> queryByUserId(Integer userId) {
        return articleMapper.queryByUserId(userId);
    }
}
