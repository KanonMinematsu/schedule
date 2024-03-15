package jp.ac.ohara.schedule.controller;
 
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.schedule.model.Private;
import jp.ac.ohara.schedule.model.Schedule;
import jp.ac.ohara.schedule.service.PrivateService;
import jp.ac.ohara.schedule.service.ScheduleService;

@SQLDelete(sql = "UPDATE address_groups SET deleted_at = NOW() WHERE id=?")
@SQLRestriction(value = "deleted_at IS NULL")
 
@Controller
public class MainController {
	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private PrivateService privateService;
	
	//@Autowired
	//private PrivateService privateService;

	@GetMapping("/")
	public String index(Model model) {
	model.addAttribute("list",this.scheduleService.getscheduleList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "user";
	}

	@GetMapping("/add/")
	public ModelAndView add(Schedule schedule, ModelAndView model) {
		model.addObject("schedule", schedule);
		model.setViewName("form");
		return model;
	}

	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull Schedule schedule, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.scheduleService.save(schedule);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/form";
	}
	@GetMapping("/ditail/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, Private privates, ModelAndView model) {
		model.addObject("list2",this.privateService.get(id));
		model.setViewName("ditail");
		return model;
	}
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, Schedule schedule, ModelAndView model) {
		this.scheduleService.delete(id);
		model.setViewName("delete");
		return model;
	}
	
	@GetMapping("/private/")
	public String index2(Model model) {
		model.addAttribute("mmm",this.privateService.getprivateList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "private";
	}
	
	@GetMapping("/add2/")
	public ModelAndView add(Private privates, ModelAndView model) {
		model.addObject("private", privates);
		model.setViewName("form2");
		return model;
	}

	@PostMapping("/add2/")
	public String add2(@Validated @ModelAttribute @NonNull Private privates, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.privateService.save(privates);
			redirectAttributes.addFlashAttribute("exception", "");
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/private/";
	}
	@GetMapping("/delete2/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, Private privates, ModelAndView model) {
		this.privateService.delete(id);
		model.setViewName("delete");
		return model;
	}
	@GetMapping("/top")
	public String index3(Model model) {
	model.addAttribute("mmm",this.privateService.getprivateList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
	
	
}