package kr.codesquad.sidedish;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SidedishApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	private static final Logger log = LoggerFactory.getLogger(SidedishApplicationTests.class);

	@Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
		log.debug("Application Context를 정상적으로 불러왔습니다.");
	}

	@Test
	void loggerLoads() {
		assertThat(log).isNotNull();
		log.debug("Logger를 정상적으로 불러왔습니다.");
	}

}
