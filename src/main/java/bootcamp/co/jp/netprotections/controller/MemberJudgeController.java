package bootcamp.co.jp.netprotections.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.co.jp.netprotections.dto.MembersJudgeRequestDto;
import bootcamp.co.jp.netprotections.dto.MembersJugdeResponseDto;
import bootcamp.co.jp.netprotections.service.MemberJudgeService;
import bootcamp.co.jp.netprotections.service.impl.MemberJudgeServiceImpl;


@RestController
@RequestMapping("/api/v1")
@Validated
public class MemberJudgeController {
	
	@Autowired
	MemberJudgeService service;
	
	@PostMapping("/check")
	@ResponseBody
	public ResponseEntity<?> checkMembers(@RequestBody @Valid MembersJudgeRequestDto dto) {	
		return new ResponseEntity<MembersJugdeResponseDto>(service.judgeMembers(dto), HttpStatus.OK);
	}
}
