package com.noboll.business.interview.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noboll.business.deliver.entity.Deliver;
import com.noboll.business.deliver.service.DeliverService;
import com.noboll.business.interview.entity.Interview;
import com.noboll.business.interview.service.InterviewService;
import com.noboll.business.resume.entity.Resume;
import com.noboll.business.resume.service.ResumeService;
import com.noboll.core.base.controller.BaseController;
import com.noboll.core.base.entity.Page;
import com.noboll.core.base.entity.QueryParam;
import com.noboll.core.exception.BusinessException;
import com.noboll.core.util.StringUtil;
import com.noboll.util.InitUtil;

/**
 * 
 * @ClassName: InterviewController
 * @Description: 面试控制器
 * @author weicb
 * @date 2016年12月26日 下午21:18:46
 *
 */
@Controller
@RequestMapping("/business/interview")
public class InterviewController extends BaseController<Interview> {

	@Resource
	private InterviewService interviewService;
	@Resource
	private DeliverService deliverService;
	@Resource
	private ResumeService resumeService;
	
	// 跳转到列表页面
	@RequestMapping("/toList")
	public String toListInterview(HttpServletRequest request,Model model) {
		return "business/interview/interview_list";
	}

	// 异步返回json数据
	@RequestMapping("/list")
	@ResponseBody
	public Object listInterview(HttpServletRequest request,Model modeld) {
		QueryParam queryParam = InitUtil.initQueryParam(request);
		Page<Interview> page = InitUtil.initPage(request);
		page = interviewService.getPageList("com.noboll.business.interview.dao.InterviewDao.getList", queryParam,
				page);
		return page;
	}

	// 电话面试（新增、修改），含预约时间
	@RequestMapping("/toDhInterview")
	public String toAddInterview(Model model,String id) {
		if (StringUtil.isEmpty(id)) 
			throw new BusinessException("无投递记录！");
		// 查找面试记录
		Interview interview = interviewService.getDhByDeliverId(id);
		model.addAttribute("interview", interview);
		// 查找投递记录
		Deliver deliver = deliverService.getEntity(id);
		if (null == deliver || StringUtil.isEmpty(deliver.getResumeId())) 
			throw new BusinessException("无投递记录！");
		model.addAttribute("deliver", deliver);
		// 查找简历记录
		Resume resume = resumeService.getEntity(deliver.getResumeId());
		model.addAttribute("resume", resume);
		
		return "business/interview/interview_dhInterview";
	}

	// 电话面试（新增、修改），含预约时间，异步返回操作信息
	@RequestMapping("dhInterview")
	@ResponseBody
	public Object addInterview(Interview interview,Resume resume) {
		interviewService.saveUpdateDhInterview(interview,resume);
		return InitUtil.sucessMessage("操作成功");
	}

	// 删除
	@RequestMapping("/remove")
	@ResponseBody
	public Object removeInterviewType(String id) {
		interviewService.deleteEntity(id);
		return InitUtil.sucessMessage("删除成功");
	}
	
}