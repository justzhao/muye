package bean.responseMessageBean;

import java.util.List;

import bean.responseMessageBean.Article;


public class ImageTextMessage extends ReBase {
	private int ArticleCount;
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
