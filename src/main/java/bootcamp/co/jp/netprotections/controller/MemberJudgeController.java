package bootcamp.co.jp.netprotections.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.JsonMappingException;

import bootcamp.co.jp.netprotections.dto.MembersJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MembersJugdeResponseDto;
import bootcamp.co.jp.netprotections.service.MemberJudgeService;


@RestController
@RequestMapping("/api/v1")
@Validated
public class MemberJudgeController {
	
	@Autowired
	MemberJudgeService service;
	
	@PostMapping("/check")
	@ResponseBody
	public ResponseEntity<?> checkMembers(@RequestBody @Valid MembersJudgeRequestDto dto, Errors errors) {
		return new ResponseEntity<MembersJugdeResponseDto>(service.judgeMembers(dto), HttpStatus.OK);
	}
	
	@ExceptionHandler({ConstraintViolationException.class, HttpMediaTypeNotSupportedException.class, 
		NullPointerException.class, HttpMessageNotReadableException.class})
	public ResponseEntity<?> handleConstraintViolation(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		MediaType content = MediaType.APPLICATION_JSON_UTF8;
		headers.setContentType(content);
		String mess = ex.getMessage()==null?"":ex.getMessage().replace("\"", "");
		String res = "{\"errorDetail\":\"" + mess + "\","
				+ "\"errorType\":\"" + ex.getClass().getSimpleName()
				+ "\"}";
		return new ResponseEntity(res, headers, HttpStatus.BAD_REQUEST);
	}
}
