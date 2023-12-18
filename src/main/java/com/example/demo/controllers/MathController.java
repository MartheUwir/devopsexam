package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.DoMathRequestDto;
import com.example.demo.exceptions.InvalidOperationException;
import com.example.demo.payload.ApiResponse;
import com.example.demo.serviceImpls.MathOperatorImpl;

@RestController
@RequestMapping("/api/v1/do_math")
public class MathController {
    private final MathOperatorImpl mathOperatorImpl;

    public MathController(MathOperatorImpl mathOperatorImpl) {
        this.mathOperatorImpl = mathOperatorImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperatorImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}