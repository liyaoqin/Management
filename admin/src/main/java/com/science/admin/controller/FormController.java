package com.science.admin.controller;

import com.science.admin.model.QueryVo;
import com.science.admin.pojo.*;
import com.science.admin.service.CnoticeService;
import com.science.admin.service.DnoticeService;
import com.science.admin.service.ProjectService;
import com.science.admin.service.ResultService;
import com.science.common.pojo.LUDataGridResult;
import com.science.common.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/page")
public class FormController {

    @Autowired
    private DnoticeService dnoticeService;

    @Autowired
    private CnoticeService cnoticeService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ResultService resultService;


    @GetMapping("/cnotice/{pid}")
    public String showCnotice(@PathVariable("pid") long pid, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("pid",pid);
        return "redirect:/page/cnotice";
    }

    @GetMapping("/cdproject/{pid}/{userid}")
    public String showcdproject(@PathVariable("pid") long pid,@PathVariable("userid") long userid,Model model) {
        model.addAttribute("pid",pid);
        model.addAttribute("userid",userid);
        return "page/dproject";
    }

    @GetMapping("/dresult/{pid}")
    public String showdresult(@PathVariable("pid") long pid,Model model) {
        Project project = projectService.getProject(pid);
        model.addAttribute("project",project);
        return "page/dresult";
    }

    @GetMapping("/vldnotice/{id}")
    public String vlDnotice(@PathVariable("id") long id,Model model) {
        Dnotice dnotice = dnoticeService.getDnotice(id);
        model.addAttribute("title",dnotice.getTitle());
        model.addAttribute("content",dnotice.getContent());
        model.addAttribute("declaration",dnotice.getDeclaration());
        return "page/vldnotice";
    }

    @GetMapping("/detaildnotice/{id}")
    public String detailDnotice(@PathVariable("id") long id,Model model) {
        LUDataGridResult result = projectService.getdetailProjectList(id);
        model.addAttribute("result",result);
        model.addAttribute("sresult",JsonUtils.objectToJson(result));
        return "page/vlpstatistics";
    }

    @GetMapping("/vlcnotice/{id}")
    public String vlCnotice(@PathVariable("id") long id,Model model) {
        Cnotice cnotice = cnoticeService.getCnotice(id);
        model.addAttribute("title",cnotice.getTitle());
        model.addAttribute("content",cnotice.getContent());
        model.addAttribute("creports",cnotice.getCreports());
        return "page/vlcnotice";
    }

    @GetMapping("/vlnproject/{id}")
    public String vlNoproject(@PathVariable("id") long id,Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "page/vlnproject";
    }

    @GetMapping("/vlnresult/{id}")
    public String vlNresult(@PathVariable("id") long id,Model model) {
        Result result = resultService.getResult(id);
        model.addAttribute("result",result);
        return "page/vlnresult";
    }

    @GetMapping("/veditnresult/{id}")
    public String veditNresult(@PathVariable("id") long id,Model model) {
        Result result = resultService.getResult(id);
        model.addAttribute("result",result);
        return "page/editnresult";
    }

    @GetMapping("/veditdnotice/{id}")
    public String veditDnotice(@PathVariable("id") long id,Model model) {
        Dnotice dnotice = dnoticeService.getDnotice(id);
        model.addAttribute("id",dnotice.getId());
        model.addAttribute("title",dnotice.getTitle());
        model.addAttribute("content",dnotice.getContent());
        model.addAttribute("declaration",dnotice.getDeclaration());
        return "page/editdnotice";
    }
    @GetMapping("/veditcnotice/{id}")
    public String veditCnotice(@PathVariable("id") long id,Model model) {
        Cnotice cnotice = cnoticeService.getCnotice(id);
        model.addAttribute("id",cnotice.getId());
        model.addAttribute("title",cnotice.getTitle());
        model.addAttribute("content",cnotice.getContent());
        model.addAttribute("creports",cnotice.getCreports());
        return "page/editcnotice";
    }
    @GetMapping("/veditnproject/{id}")
    public String veditNproject(@PathVariable("id") long id,Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "page/editnproject";
    }

    @GetMapping("/againproject/{id}")
    public String againProject(@PathVariable("id") long id,Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project",project);
        return "page/againproject";
    }
    @GetMapping("/againresult/{id}")
    public String againResult(@PathVariable("id") long id,Model model) {
        Result result = resultService.getResult(id);
        model.addAttribute("result",result);
        return "page/againresult";
    }

    @GetMapping("/npassproject/{id}")
    public String npassProject(@PathVariable("id") long id,Model model) {
        model.addAttribute("id",id);
        return "page/npassproject";
    }

    @GetMapping("/npassresult/{id}")
    public String npassResult(@PathVariable("id") long id,Model model) {
        model.addAttribute("id",id);
        return "page/npassresult";
    }

    @RequestMapping(value = "/submitUserList_4", method ={RequestMethod.POST})
    @ResponseBody
    public String submitUserList_4(@RequestBody List<User> users)
            throws Exception{
        String s = JsonUtils.objectToJson(users);
        return s;
    }

}
