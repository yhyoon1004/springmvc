package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Slf4j
//@RestController
@Controller
public class RequestParamController {
	@RequestMapping("/request-param-v1")
	public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		log.info("username={}, age={}", username, age);

		response.getWriter().write("ok");

	}

	@ResponseBody//ResController와 같은 효과 리턴되는 String을 뷰에 보내지 않고 HttpBody에 박아 넣음
	@RequestMapping("/request-param-v2")
	public String requestParamV2(
			@RequestParam("username") String memberName,
			@RequestParam("age") int memberAge) {
		log.info("username={}, age={}", memberName, memberAge);

		return "ok";
	}

	@ResponseBody//ResController와 같은 효과 리턴되는 String을 뷰에 보내지 않고 HttpBody에 박아 넣음
	@RequestMapping("/request-param-v3")
	public String requestParamV3(
			@RequestParam String username,
			@RequestParam int age) {
		log.info("username={}, age={}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {//받아온 파라미터 이름이 같으면 애너테이션 생략가능
		log.info("username={}, age={}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(
			@RequestParam(required = true) String username,
			@RequestParam(required = false) Integer age) {
		log.info("username={}, age={}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
			@RequestParam(required = true, defaultValue = "guest") String username,//defaultValue 는 "" 빈문자열도 설정한 값으로 적용된다.
			@RequestParam(required = false, defaultValue = "-1") int age) {
		log.info("username={}, age={}", username, age);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
		log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/model-attribute-v1")
//	public String modelAttributeV1(@RequestParam String username, @RequestParam int age ){
	public String modelAttributeV1(@ModelAttribute HelloData helloData) {
//		HelloData helloData = new HelloData();
//		helloData.setUsername(username);
//		helloData.setAge(age);

		log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
		log.info("helloData={}", helloData);

		return "ok";
	}

	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(HelloData helloData) {

		log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
		log.info("helloData={}", helloData);

		return "ok";
	}

}
