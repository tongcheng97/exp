package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BmiController {
	
	@RequestMapping("/bmi_form.do")
	public String tobmi() {
		return "bmi_form";
	}
	
	@RequestMapping("/bmi.do")
	public String bmi(HttpServletRequest req) {
		double weight = Double.parseDouble(req.getParameter("weight"));
		double height = Double.parseDouble(req.getParameter("height"));
		double bmi = (weight/height)/height;
		req.setAttribute("bmi", bmi);
		req.setAttribute("weight", weight);
		req.setAttribute("height", height);
		if(bmi<19) {
			req.setAttribute("result", "过轻");
		}else {
			if(bmi>25) {
				req.setAttribute("result", "过重");
			}else {
				req.setAttribute("result", "正常");
			}
		}
		return "view";
		
	}
}
