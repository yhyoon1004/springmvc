package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j//lombok이 제공하는 로그 애너테이션
@RestController//RestApi에 그 Rest가 맞음
//@Controller를 박으면 view경로로 String을 인식함;;
public class LogTestController {
	private final Logger log = LoggerFactory.getLogger(getClass());//getClass() <- 현재 내 클래스 반환 (= LogTestController.class)

	@RequestMapping("/log-test")
	public String logTest(){
		String name = "Spring";

		log.trace("trace log={}",name);
		log.debug("debug log={}",name);//디버그할 때 보는 것 개발서버등,,
		log.info("info log={}",name);//중요한 정보 비지니스 로직, 운영시스템 등등,,
		log.warn("warn log={}",name);//경고 위험한 것
		log.error("error log={}",name);//에러 꼭 확인해야돼

		return "ok";//@RestContoller에 의해서 HttpMessageBody에 해당 문자가 박힘
	}


}
