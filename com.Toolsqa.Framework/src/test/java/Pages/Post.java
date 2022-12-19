package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Post
{
	

	@FindBy(how=How.XPATH,using="//*[@id='menu-posts']/a") 
	WebElement link;

	@FindBy(xpath="//h2/a[text()='Add New']")
	WebElement add_new_post;
	
	@FindBy(id="title") 
	WebElement enter_post_title;
	
	@FindBy(id="publish")
	WebElement publish_button;
	
	@FindBy(xpath=".//*[@id='message']/p")
	WebElement success_msg;
	
	
	public void publish_article_on_wordpress()
	{
	
		link.click();
		add_new_post.click();
		enter_post_title.sendKeys("Selenium 8 Aug Batch Class 12 Hybrid fW");
		publish_button.click();	
	}
	
	public void validate_post(){
		String msg=success_msg.getText();
		Assert.assertTrue(msg.contains("Post Publised"));
	}
	
}
