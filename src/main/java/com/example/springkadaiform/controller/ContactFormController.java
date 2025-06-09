package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String showForm(ContactForm contactFotm) {
		return "contactFormView";
	}
	
	@PostMapping("/confirm")
	public String confirm(@Valid @ModelAttribute ContactForm contactForm,
				BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "contactFormView";
		}
		model.addAttribute("contactForm", contactForm);
		return "confirmView";
	}

	
	/* フォーム・確認画面への各リクエストに応じて、表示内容を切り替える必要がある
	 	
	 	バリデーションOK：確認画面を表示
	 	バリデーションNG：元のフォームへリダイレクト
	 */
}
