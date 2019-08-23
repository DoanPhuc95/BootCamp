package bootcamp.co.jp.netprotections.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

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
	
	@ExceptionHandler
	public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
}
