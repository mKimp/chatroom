package com.chatroomexample.chatroom;

import com.chatroomexample.chatroom.Model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatroomApplicationTests {
	@LocalServerPort
	public int port;

	public static WebDriver webDriver;

	public static String baseURL;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll(){
		webDriver.quit();
		webDriver = null;
	}
	@BeforeEach
	public void beforeEach(){
		baseURL = "http://localhost:" + port;
	}

	@Test
	public void testUserSignUpLoginandSubmitMessage() throws InterruptedException {
		String username = "kim";
		String password = "123";
		String messageText = "Hello the testing world";

		webDriver.get(baseURL+"/signup");
		SignUpPage signUpPage = new SignUpPage(webDriver);
		signUpPage.signup("SuperMan", "SuperMoon", username, password);

		Thread.sleep(5000);

		webDriver.get(baseURL+"/login");
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.logIn(username, password);

		Thread.sleep(5000);

		webDriver.get(baseURL+"/chat");
		ChatPage chatPage = new ChatPage(webDriver);
		chatPage.sendMessage(messageText);
		ChatMessage chatMessage = chatPage.getFirstMessage();

		Thread.sleep(5000);

		assertEquals(username, chatMessage.getUsername());
		assertEquals(messageText, chatMessage.getMessageText());
	}

}
